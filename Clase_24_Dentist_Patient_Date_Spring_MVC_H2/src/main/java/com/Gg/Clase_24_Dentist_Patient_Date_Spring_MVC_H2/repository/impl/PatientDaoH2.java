package com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.impl;

import com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Address;
import com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.Idao;
import com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDaoH2 implements Idao<Patient> {

    Logger logger = LogManager.getLogger(PatientDaoH2.class);

    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URl = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";
    AddressDaoH2 addressDaoH2 = new AddressDaoH2();

    @Override
    public Patient register(Patient patient) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        AddressDaoH2 addressDaoH2 = new AddressDaoH2();
        String SQL_INSERT = "INSERT INTO PATIENTS (NAME, LASTNAME, ADDRESS_ID,DNI,DATE_INIT) VALUES (?,?,?,?,?)";
        Patient patient1 = null;

        try {
            logger.info("Registering patient");
            Class.forName(DB_JDBC_DRIVER);
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
    public Patient search(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Patient patient = null;
        String SQL_SELECT = "SELECT * FROM PATIENTS WHERE ID = ?";
        try {
            logger.info("Searching patient");
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            logger.info("Patient found");
            if (resultSet.next()) {
                Address address = addressDaoH2.search(resultSet.getInt("ADDRESS_ID"));
                patient = new Patient(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), address, resultSet.getInt(5), new Date(resultSet.getDate(6).getTime()));
            }
            preparedStatement.close();
            connection.close();
            logger.info("Patient searched successfully");
        } catch (Exception e) {
            logger.error("Search Patient Error, " + e.getMessage());
        }
        return patient;
    }

    @Override
    public Patient update(Integer id, Patient patient) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Patient patient1 = null;
        String SQL_UPDATE = "UPDATE PATIENTS SET NAME = ?, LASTNAME = ?, ADDRESS_ID = ?, DNI = ?, DATE_INIT = ? WHERE ID = ?";
        try {
            logger.info("Updating patient");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setInt(3, addressDaoH2.update(patient.getAddress().getAddressId(), patient.getAddress()).getAddressId());
            preparedStatement.setInt(4, patient.getDni());
            preparedStatement.setDate(5, new java.sql.Date(patient.getDateInit().getTime()));
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            patient1 = patient;
            logger.info("Patient updated successfully");
        } catch (Exception e) {
            logger.error("Update Patient Error, " + e.getMessage());
        }
        return patient1;
    }

    @Override
    public void delete(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_DELETE = "DELETE FROM PATIENTS WHERE ID = ?";
        try {
            logger.info("Deleting patient");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            addressDaoH2.delete(search(id).getAddress().getAddressId());
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            logger.info("Patient deleted successfully");
        } catch (Exception e) {
            logger.error("Delete Patient Error, " + e.getMessage());
        }
    }


    @Override
    public List<Patient> searchAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Patient> patientsList = new ArrayList();
        String SQL_SELECT = "SELECT * FROM PATIENTS";
        try {
            Class.forName(DB_JDBC_DRIVER);
            logger.info("Searching all patients");
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Address address = addressDaoH2.search(resultSet.getInt("ADDRESS_ID"));
                patientsList.add(new Patient(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), address, resultSet.getInt(5), new Date(resultSet.getDate(6).getTime())));
            }
            preparedStatement.close();
            connection.close();
            logger.info("Patients searched successfully");
        } catch (Exception e) {
            logger.error("Search All Patients Error, " + e.getMessage());
        }
        return patientsList;
    }
}
