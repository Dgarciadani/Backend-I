package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.impl;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Address;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.Idao;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            logger.error("Error registering address"+ e.getMessage());
        }
        return address1;
    }

    @Override
    public Address search(int id) {
        return null;
    }

    @Override
    public Address update(int id, Address address) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Address> searchAll() {
        return null;
    }
}
