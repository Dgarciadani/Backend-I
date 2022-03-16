package Dao;

import Entities.Address;
import Entities.Patient;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Util.Date;
import Util.Date.*;
import org.apache.log4j.Logger;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class PatientDaoH2 implements IDao<Patient> {
    private static final Logger logger = Logger.getLogger(PatientDaoH2.class);

    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/db_clinica;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    private AddressDaoH2 addressDaoH2 = new AddressDaoH2();


    @Override
    public Patient register(Patient patient) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_INSERT = "INSERT INTO patients(name,lastname,dni,DateInit,address_id) values(?,?,?,?,?)";
        logger.info("Register patient init");

        try {
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            //instance a new address and send it to register on addressDB
            Address address = addressDaoH2.register(patient.getAddress());
            //GET DE ID Generated in DB and set it in the patient instance
            patient.getAddress().setId(address.getId());

            //Statement.RETURN_GENERATED_KEYS Return the Id generated in PatientDB
            prepareStatement = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            prepareStatement.setString(1, patient.getName());
            prepareStatement.setString(2, patient.getLastname());
            prepareStatement.setInt(3, patient.getDNI());
            //use external method to convert the utilDate to SQL Date
            prepareStatement.setDate(4, Date.utilDateToSQLDate(patient.getDateInit()));

            prepareStatement.setInt(5, patient.getAddress().getId());

            prepareStatement.executeUpdate();

            //Save the keys(id) generated in patient
            ResultSet keys = prepareStatement.getGeneratedKeys();
            if (keys.next()) {
                patient.setId(keys.getInt(1));
            }

            prepareStatement.close();
            logger.info("Register Patient: SUCCESS");

        } catch (Exception e) {
            logger.error("Register Patient: ERROR, " + e.getMessage());
        }
        return patient;


    }

    @Override
    public Patient search(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Patient update(int i, Object o) {
        return null;
    }
}
