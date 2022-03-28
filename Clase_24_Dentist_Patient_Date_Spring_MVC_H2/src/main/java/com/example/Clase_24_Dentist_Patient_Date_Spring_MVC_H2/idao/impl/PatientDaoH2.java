package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.impl;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Address;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Patient;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.Idao;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public class PatientDaoH2 implements Idao<Patient> {
    Logger logger = org.slf4j.LoggerFactory.getLogger(PatientDaoH2.class);

    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URl = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";


    @Override
    public Patient register(Patient patient) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        AddressDaoH2 addressDaoH2 = new AddressDaoH2();
        String SQL_INSERT = "INSERT INTO PATIENTS (NAME, LASTNAME, ADDRESS_ID,DNI,DATE_INIT) VALUES (?,?,?,?,?)";
        Patient patient1 = null;

        try {
            logger.info("Registering patient");
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            Address address = patient.getAddress();
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setInt(3, addressDaoH2.register(address).getAddressId());
            preparedStatement.setInt(4, patient.getDni());
            preparedStatement.setDate(5, new java.sql.Date(patient.getDateInit().getTime()));
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();

            if (keys.next()) {
                patient.setPatient_id(keys.getInt(1));
            }
            preparedStatement.close();
            connection.close();
            patient1 = patient;
            logger.info("Patient registered successfully");


        } catch (Exception e) {
            logger.error("Register Patient Error," + e.getMessage());

        }

        return patient1;
    }

    @Override
    public Patient search(int id) {
        return null;
    }

    @Override
    public Patient update(int id, Patient patient) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Patient> searchAll() {
        return null;
    }
}
