package Dao;

import Models.Address;
import Models.Patient;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import Util.Date;
import org.apache.log4j.Logger;

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
        Patient patient1 = null;
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_SELECT = "SELECT * FROM PATIENTS WHERE ID=?";

        try {
            logger.info("Search Patient init");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_SELECT);
            prepareStatement.setInt(1, id);
            ResultSet rs = prepareStatement.executeQuery();

            while (rs.next()) {
                Address address = addressDaoH2.search(rs.getInt(6));
                patient1 = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), address);
            }
            prepareStatement.close();
            logger.info("Search Patient: SUCCESS");

        } catch (Exception e) {
            logger.error("Search Patient: ERROR, " + e.getMessage());

        }
        return patient1;
    }

    @Override
    public void delete(int id) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_DELETE = "DELETE FROM PATIENTS WHERE ID=?";

        try {
            logger.info("Delete Patient init");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_DELETE);
            prepareStatement.setInt(1, id);
            addressDaoH2.delete(addressDaoH2.search(id).getId());
            prepareStatement.executeUpdate();
            logger.info("Delete Patient: SUCCESS");
        } catch (Exception e) {
            logger.error("Delete Patient: ERROR, " + e.getMessage());
        }

    }

    @Override
    public Patient update(int id, Patient patient) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_UPDATE = "UPDATE PATIENTS SET name=?,lastname=?,dni=?,DateInit=?,address_id=? WHERE ID=?";
        Patient patient1 = null;
        try {
            logger.info("Update Patient Init");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Address address = addressDaoH2.search(patient.getAddress().getId());
            addressDaoH2.update(patient.getAddress().getId(), patient.getAddress());
            prepareStatement = conn.prepareStatement(SQL_UPDATE);
            prepareStatement.setInt(6, id);
            prepareStatement.setString(1, patient.getName());
            prepareStatement.setString(2, patient.getLastname());
            prepareStatement.setInt(3, patient.getDNI());
            prepareStatement.setDate(4, Util.Date.utilDateToSQLDate(patient.getDateInit()));
            prepareStatement.setInt(5, address.getId());
            prepareStatement.executeUpdate();
            prepareStatement.close();
            patient1 = patient;
            logger.info("Update Patient: SUCCESS");

        } catch (Exception e) {
            logger.error("Update Patient: ERROR, " + e.getMessage());
        }
        return patient1;
    }


    @Override
    public List<Patient> searchAll() {
        List<Patient> allPatients = new ArrayList<>();
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_SELECT_ALL = " SELECT * FROM PATIENTS";
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Address address = addressDaoH2.search(rs.getInt(6));
                Patient patient = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), address);
                allPatients.add(patient);
            }
            prepareStatement.close();
            logger.info("Search All Patients: SUCCESS");

        } catch (Exception e) {
            logger.error("Search All Patients: ERROR, " + e.getMessage());
        }
        return allPatients;
    }

}
