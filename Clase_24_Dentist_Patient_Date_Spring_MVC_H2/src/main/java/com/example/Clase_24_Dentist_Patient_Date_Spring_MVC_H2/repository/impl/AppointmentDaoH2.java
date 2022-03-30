package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.impl;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Appointment;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Dentist;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Patient;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.Idao;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services.DentistService;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services.PatientService;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppointmentDaoH2 implements Idao<Appointment> {
    Logger logger = LogManager.getLogger(AppointmentDaoH2.class);


    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URl = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";
    PatientService patientService = new PatientService(new PatientDaoH2());
    DentistService dentistService = new DentistService(new DentistDaoH2());

    @Override
    public Appointment register(Appointment appointment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_INSERT = "INSERT INTO appointments (dentist_id, patient_id, date_init) VALUES ( ?, ?, ?)";
        try {
            logger.info("Registering new appointment");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, appointment.getDentist().getDentist_id());
            preparedStatement.setInt(2, appointment.getPatient().getPatient_id());
            preparedStatement.setDate(3, new Date(appointment.getDate().getTime()));
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()) {
                appointment.setAppointment_id(keys.getInt(1));
            }
            logger.info("Appointment registered successfully");

        } catch (Exception e) {
            logger.error("Error registering appointment" + e.getMessage());
        }
        return appointment;
    }

    @Override
    public Appointment search(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_SELECT = "SELECT * FROM APPOINTMENTS WHERE ID = ?";
        Appointment appointment = null;

        try {
            logger.info("Searching for appointment");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Patient patient = patientService.search(resultSet.getInt(2));
                Dentist dentist = dentistService.search(resultSet.getInt(3));
                appointment = new Appointment(resultSet.getInt(1), dentist, patient, new java.util.Date(resultSet.getDate(4).getTime()));
            }
            logger.info("Appointment found successfully");
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            logger.error("Error searching for appointment" + e.getMessage());
        }
        return appointment;

    }

    @Override
    public Appointment update(Integer id, Appointment appointment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_UPDATE = "UPDATE APPOINTMENTS SET PATIENT_ID = ?, DENTIST_ID = ?, DATE = ? WHERE ID = ?";
        Appointment appointment1 = null;
        try {
            logger.info("Updating appointment");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setInt(2, appointment.getDentist().getDentist_id());
            preparedStatement.setInt(3, appointment.getPatient().getPatient_id());
            preparedStatement.setDate(4, new Date(appointment.getDate().getTime()));
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();

            appointment1 = appointment;
            appointment1.setAppointment_id(id);
            logger.info("Appointment updated successfully");

        } catch (Exception e) {
            logger.error("Error updating appointment, " + e.getMessage());
        }
        return appointment1;
    }

    @Override
    public void delete(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_DELETE = "DELETE FROM APPOINTMENTS WHERE ID = ?";
        try {
            logger.info("Deleting appointment");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            logger.info("Appointment deleted successfully");

        } catch (Exception e) {
            logger.error("Error deleting appointment, " + e.getMessage());
        }
    }

    @Override
    public List<Appointment> searchAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_SELECT = "SELECT * FROM APPOINTMENTS";
        List<Appointment> appointmentsList = new ArrayList();
        try {
            logger.info("Searching for all appointments");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Patient patient = patientService.search(resultSet.getInt(3));
                Dentist dentist = dentistService.search(resultSet.getInt(2));
                Appointment appointment = new Appointment(resultSet.getInt(1), dentist, patient, new java.util.Date(resultSet.getDate(4).getTime()));
                appointmentsList.add(appointment);
            }
            logger.info("All appointments found successfully");
        } catch (Exception e) {
            logger.error("Error searching for all appointments, " + e.getMessage());
        }
        return appointmentsList;
    }
}
