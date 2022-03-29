package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.impl;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Appointment;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.Idao;
import org.slf4j.Logger;


import java.sql.*;
import java.util.List;

public class AppointmentDaoH2 implements Idao<Appointment> {
    Logger logger = org.slf4j.LoggerFactory.getLogger(AppointmentDaoH2.class);


    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URl = "jdbc:h2:~/test";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    @Override
    public Appointment register(Appointment appointment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_INSERT = "INSERT INTO appointments (patient_id, dentist_id, date) VALUES ( ?, ?, ?)";
        try {
            logger.info("Registering new appointment");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, appointment.getPatient().getPatient_id());
            preparedStatement.setInt(2, appointment.getDentist().getDentist_id());
            preparedStatement.setDate(3, new Date(appointment.getDate().getTime()));
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()) {
                appointment.setAppointment_id(keys.getInt(1));
            }
            logger.info("Appointment registered successfully");

        } catch (Exception e) {
            logger.error("Error registering appointment"+ e.getMessage());
        }
        return appointment;
    }

    @Override
    public Appointment search(int id) {
        return null;
    }

    @Override
    public Appointment update(int id, Appointment appointment) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Appointment> searchAll() {
        return null;
    }
}
