package Dao;

import Entities.Address;
import org.apache.log4j.Logger;

import java.sql.*;

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

    }

    @Override
    public Address update(int i, Object o) {
        return null;
    }
}
