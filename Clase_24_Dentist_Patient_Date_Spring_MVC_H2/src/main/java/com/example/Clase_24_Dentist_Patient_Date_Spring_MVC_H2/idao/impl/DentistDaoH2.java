package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.impl;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Dentist;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.Idao;
import org.slf4j.Logger;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public class DentistDaoH2 implements Idao<Dentist> {
Logger logger = org.slf4j.LoggerFactory.getLogger(DentistDaoH2.class);

    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URl = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";


    @Override
    public Dentist register(Dentist dentist) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_CREATE = "INSERT INTO DENTISTS(NAME,LASTNAME,REGISTER) VALUES(?,?,?);";

        try {
            logger.info("Registering dentist");
         Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, dentist.getName());
            preparedStatement.setString(2, dentist.getLastName());
            preparedStatement.setInt(3, dentist.getRegister());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                dentist.setDentist_id(resultSet.getInt(1));
            }
            preparedStatement.close();
            logger.info("Dentist registered");


        } catch (Exception e) {
            logger.error("Error registering dentist", e);

        }
        return dentist;
    }

    @Override
    public Dentist search(int id) {
        return null;
    }

    @Override
    public Dentist update(int id, Dentist dentist) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Dentist> searchAll() {
        return null;
    }
}
