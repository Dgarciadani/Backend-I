package com.example.Clase_25A_SpringBoot_API_Exercise.dao;

import com.example.Clase_25A_SpringBoot_API_Exercise.domain.Medicines;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoMedicineH2 implements Idao<Medicines> {

    private static final Logger logger = Logger.getLogger(DaoMedicineH2.class);

    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URl = "jdbc:h2:~/Medicines";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    @Override
    public Medicines register(Medicines medicines) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        try {
            String SQL_INSERT = "INSERT INTO MEDICINES VALUES(?,?,?,?)";
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_INSERT);
            prepareStatement.setString(1, medicines.getName());
            prepareStatement.setString(2, medicines.getBrand());
            prepareStatement.setLong(3, medicines.getId());
            prepareStatement.setLong(4, medicines.getRegistryFDA());
            prepareStatement.executeUpdate();
            prepareStatement.close();
            logger.info("INSERT medicine values: SUCCESS");

        } catch (Exception e) {
            logger.error("INSERT medicine values: ERROR," + e.getMessage());
        }
        return medicines;
    }

    @Override
    public void delete(long id) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        try {
            String SQL_DELETE = "DELETE FROM MEDICINES WHERE ID=?";
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_DELETE);
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
            prepareStatement.close();
            logger.info("DELETE medicine: SUCCESS");
        } catch (Exception e) {
            logger.error("DELETE medicine: ERROR, " + e.getMessage());
        }

    }

    @Override
    public Medicines search(long id) {
        Medicines medicine = null;
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        try {
            String SQL_SELECT = "SELECT * FROM MEDICINES WHERE ID=?";
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_SELECT);
            prepareStatement.setLong(1, id);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                medicine = new Medicines();
                medicine.setName(rs.getString(1));
                medicine.setBrand(rs.getString(2));
                medicine.setId(rs.getLong(3));
                medicine.setRegistryFDA(rs.getLong(4));
                logger.debug(medicine);
            }

        } catch (Exception e) {
            logger.error("SELECT medicine: ERROR, " + e.getMessage());
        }
        return medicine;
    }

    @Override
    public List<Medicines> searchAll() {
        List<Medicines> medicineList = new ArrayList();
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        Medicines medicine = null;
        try {
            String SQL_SELECTALL = "SELECT * FROM MEDICINES";
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_SELECTALL);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                medicine = new Medicines();
                medicine.setName(rs.getString(1));
                medicine.setBrand(rs.getString(2));
                medicine.setId(rs.getLong(3));
                medicine.setRegistryFDA(rs.getLong(4));
                logger.debug(medicine);
                medicineList.add(medicine);
            }

        } catch (Exception e) {
            logger.error("LIST ALL medicine: ERROR, " + e.getMessage());
        }
        return medicineList;
    }
}
