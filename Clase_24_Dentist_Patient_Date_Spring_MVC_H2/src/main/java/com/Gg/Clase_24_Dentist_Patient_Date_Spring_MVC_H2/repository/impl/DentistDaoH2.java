package com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.impl;

import com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.Idao;
import com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Dentist;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class DentistDaoH2 implements Idao<Dentist> {
    Logger logger = LogManager.getLogger(DentistDaoH2.class);

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
            logger.info("Dentist registered successfully");


        } catch (Exception e) {
            logger.error("Error registering dentist", e);

        }
        return dentist;
    }

    @Override
    public Dentist search(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_READ = "SELECT * FROM DENTISTS WHERE ID = ?";
        Dentist dentist = null;
        try {
            logger.info("Searching dentist");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_READ);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                dentist = new Dentist(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));


            }
            preparedStatement.close();
            logger.info("Dentist found");

        } catch (Exception e) {
            logger.error("Error searching dentist" + e.getMessage());
        }


        return dentist;
    }

    @Override
    public Dentist update(Integer id, Dentist dentist) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_UPDATE = "UPDATE DENTISTS SET NAME = ?, LASTNAME = ?, REGISTER = ? WHERE ID = ?";
        Dentist dentist1 = null;
        try {
            logger.info("Updating dentist");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, dentist.getName());
            preparedStatement.setString(2, dentist.getLastName());
            preparedStatement.setInt(3, dentist.getRegister());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            dentist.setDentist_id(id);
            dentist1 = dentist;
            logger.info("Dentist updated");

        } catch (Exception e) {
            logger.error("Error updating dentist, " + e.getMessage());

        }


        return dentist1;
    }

    @Override
    public void delete(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_DELETE = "DELETE FROM DENTISTS WHERE ID = ?";
        try {
            logger.info("Deleting dentist");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            logger.info("Dentist deleted");

        } catch (Exception e) {
            logger.error("Error deleting dentist", e);

        }

    }

    @Override
    public List<Dentist> searchAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_READ = "SELECT * FROM DENTISTS";
        List<Dentist> dentistsList = new ArrayList();
        try {
            logger.info("Searching all dentists");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_READ);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Dentist dentist = new Dentist(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                dentistsList.add(dentist);
            }
            preparedStatement.close();
            logger.info("Dentists List found");

        } catch (Exception e) {
            logger.error("Error searching all dentists" + e.getMessage());

        }
        return dentistsList;
    }
}
