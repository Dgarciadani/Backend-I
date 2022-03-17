package Dao;

import Models.Address;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoH2 implements IDao<Address> {

    private static final Logger logger = Logger.getLogger(PatientDaoH2.class);

    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/db_clinica;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";


    @Override
    public Address register(Address address) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_INSERT = "INSERT INTO Address(street,door,locality,state) VALUES(?,?,?,?)";


        try {
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            prepareStatement = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1, address.getStreet());
            prepareStatement.setInt(2, address.getDoor());
            prepareStatement.setString(3, address.getLocality());
            prepareStatement.setString(4, address.getState());
            prepareStatement.executeUpdate();

            ResultSet keys = prepareStatement.getGeneratedKeys();
            if (keys.next()) {
                address.setId(keys.getInt(1));
            }

            prepareStatement.close();
            logger.info("Register Address: SUCCESS");

        } catch (Exception e) {
            logger.error("register Address: ERROR, " + e.getMessage());
        }
        return address;
    }

    @Override
    public Address search(int id) {
        Address address1 = null;
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_SELECT = "SELECT * FROM ADDRESS WHERE ID=?";

        try {
            logger.info("Search Address init");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_SELECT);
            prepareStatement.setInt(1, id);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                address1 = new Address(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            }
            prepareStatement.close();
            logger.info("Search Address: SUCCESS");

        } catch (Exception e) {
            logger.error("Search Address: ERROR, " + e.getMessage());
        }

        return address1;
    }

    @Override
    public void delete(int id) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_DELETE = "DELETE FROM ADDRESS WHERE ID=?";
        try {
            logger.info("Delete Address Init");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_DELETE);
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
            prepareStatement.close();
            logger.info("Delete Address: SUCCESS");

        } catch (Exception e) {
            logger.error("Delete Address: ERROR, " + e.getMessage());
        }
    }

    @Override
    public Address update(int id, Address address) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_UPDATE = "UPDATE ADDRESS SET street=?,door=?,locality=?,state=? WHERE ID=?";
        Address address1 = null;
        try {
            logger.info("Update Address Init");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_UPDATE);
            prepareStatement.setInt(5, id);
            prepareStatement.setString(1, address.getStreet());
            prepareStatement.setInt(2, address.getDoor());
            prepareStatement.setString(3, address.getLocality());
            prepareStatement.setString(4, address.getState());

            prepareStatement.executeUpdate();
            prepareStatement.close();
            address1 = address;
            logger.info("Update Address: SUCCESS");

        } catch (Exception e) {
            logger.error("Update Address: ERROR, " + e.getMessage());
        }
        return address1;
    }

    @Override
    public List<Address> searchAll() {
        List<Address> allAddress = new ArrayList<>();
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_SELECT_ALL = " SELECT * FROM ADDRESS";
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Address address = new Address(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                allAddress.add(address);
            }
            prepareStatement.close();
            logger.info("Search All Address: SUCCESS");

        } catch (Exception e) {
            logger.error("Search All Address: ERROR, " + e.getMessage());
        }

        return allAddress;
    }


}
