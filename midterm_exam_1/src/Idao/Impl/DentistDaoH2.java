package Idao.Impl;

import Idao.IDao;
import Models.Dentist;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DentistDaoH2 implements IDao<Dentist> {
    private static final Logger logger = Logger.getLogger(DentistDaoH2.class);

    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/Test;" + "INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";


    @Override
    public Dentist register(Dentist dentist) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        Dentist dentist1 = null;
        String SQL_INSERT = "INSERT INTO DENTISTS VALUES(?,?,?)";
        try {
            logger.info("Register Dentist init");
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_INSERT);
            prepareStatement.setLong(1, dentist.getLicense_id());
            prepareStatement.setString(2, dentist.getName());
            prepareStatement.setString(3, dentist.getLastName());
            prepareStatement.executeUpdate();
            prepareStatement.close();
            dentist1 = dentist;
            logger.info("Register Dentist: SUCCESS");

        } catch (Exception e) {
            logger.error("Register Dentist: ERROR, " + e.getMessage());
        }
        return dentist1;
    }

    @Override
    public Dentist search(Long license_id) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        Dentist dentist1 = null;
        String SQL_SELECT = "SELECT * FROM DENTISTS WHERE licence_id=?";
        try {
            logger.info("Select Dentist init");
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_SELECT);
            prepareStatement.setLong(1, license_id);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                dentist1 = new Dentist(rs.getLong(1), rs.getString(2), rs.getString(3));
            }
            prepareStatement.close();
            logger.info("Select Dentist: SUCCESS");
        } catch (Exception e) {
            logger.error("Select Dentist: ERROR, " + e.getMessage());
        }
        return dentist1;
    }

    @Override
    public void delete(Long license_id) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_DELETE = "DELETE FROM DENTISTS WHERE Licence_id=?";
        try {
            logger.error("Delete Dentist Init");
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_DELETE);
            prepareStatement.setLong(1, license_id);
            prepareStatement.executeUpdate();
            prepareStatement.close();
            logger.info("Delete Dentist: SUCCESS");
        } catch (Exception e) {
            logger.error("Delete Dentist: ERROR, " + e.getMessage());
        }
    }

    @Override
    public List<Dentist> searchAll() {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        List<Dentist> Alldentist = new ArrayList();
        String SQL_SELECTALL = "SELECT * FROM DENTISTS";
        try {
            logger.info("Select All Dentists Init");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_SELECTALL);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Dentist dentist = new Dentist(rs.getLong(1), rs.getString(2), rs.getString(3));
                Alldentist.add(dentist);
            }
            logger.info("Select All Dentists: SUCCESS");
        } catch (Exception e) {
            logger.error("Select All Dentists: ERROR, " + e.getMessage());
        }
        return Alldentist;
    }
}
