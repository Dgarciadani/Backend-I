package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.impl;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Address;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.Idao;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoH2 implements Idao<Address> {
    Logger logger = org.slf4j.LoggerFactory.getLogger(AddressDaoH2.class);

    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URl = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    @Override
    public Address register(Address address) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_INSERT = "INSERT INTO ADDRESS (STREET, DOOR ,CITY, STATE) VALUES (?,?,?,?)";
        Address address1 = null;
        try {
            logger.info("Registering address");
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setInt(2, address.getDoor());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getState());
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();

            if (keys.next()) {
                address.setAddressId(keys.getInt(1));
            }
            preparedStatement.close();
            address1 = address;
            logger.info("Address registered successfully");

        } catch (Exception e) {
            logger.error("Error registering address" + e.getMessage());
        }
        return address1;
    }

    @Override
    public Address search(int id) {
        logger.info("Searching address with id: " + id);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_SELECT = "SELECT * FROM ADDRESS WHERE ID = ?";
        Address address = null;
        try {
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                address = new Address(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
            }
            preparedStatement.close();
            connection.close();
            logger.info("Address found successfully");
        } catch (Exception e) {
            logger.error("Error searching address" + e.getMessage());
        }
        return address;
    }

    @Override
    public Address update(int id, Address address) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_UPDATE = "UPDATE ADDRESS SET STREET = ?, DOOR = ?, CITY = ?, STATE = ? WHERE ID = ?";
        Address address1 = null;
        try {
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setInt(2, address.getDoor());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getState());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            address1 = address;
            logger.info("Address updated successfully");

        } catch (Exception e) {
            logger.error("Error updating address, " + e.getMessage());
        }
        return address1;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_DELETE = "DELETE FROM ADDRESS WHERE ID = ?";
        try {
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            logger.info("Address deleted successfully");

        } catch (Exception e) {
            logger.error("Error deleting address, " + e.getMessage());
        }

    }

    @Override
    public List<Address> searchAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_SELECT = "SELECT * FROM ADDRESS";
        List<Address> addressList = new ArrayList();
        try {
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Address address = new Address(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
                addressList.add(address);
            }
            preparedStatement.close();
            connection.close();
            logger.info("Address List found successfully");
        } catch (Exception e) {
            logger.error("Error searching all addresses, " + e.getMessage());

        }

        return addressList;
    }

}
