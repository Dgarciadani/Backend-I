package com.example.Clase_25A_SpringBoot_API_Exercise.dao;

import com.example.Clase_25A_SpringBoot_API_Exercise.domain.Medicine;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoMedicineH2 implements Idao<Medicine> {
    Logger logger = org.slf4j.LoggerFactory.getLogger(DaoMedicineH2.class);

    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URl = "jdbc:h2:~/Medicines;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    @Override
    public Medicine register(Medicine medicine) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        Medicine medicine1 = null;
        try {
            String SQL_INSERT = "INSERT INTO MEDICINES(NAME,BRAND,REGISTRY) VALUES(?,?,?)";
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1, medicine.getName());
            prepareStatement.setString(2, medicine.getBrand());
            prepareStatement.setInt(3, medicine.getRegistryFDA());
            prepareStatement.executeUpdate();
            ResultSet keys = prepareStatement.getGeneratedKeys();
            if (keys.next()) {
                medicine.setId(keys.getInt(1));
            }
            prepareStatement.close();
            medicine1 = medicine;
            logger.info("INSERT medicine values: SUCCESS");

        } catch (Exception e) {
            logger.error("INSERT medicine values: ERROR," + e.getMessage());
        }
        return medicine1;
    }

    @Override
    public void delete(int id) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        try {
            String SQL_DELETE = "DELETE FROM MEDICINES WHERE ID=?";
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_DELETE);
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
            prepareStatement.close();
            logger.info("DELETE medicine: SUCCESS");
        } catch (Exception e) {
            logger.error("DELETE medicine: ERROR, " + e.getMessage());
        }

    }

    @Override
    public Medicine search(int id) {
        Medicine medicine = null;
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        try {
            String SQL_SELECT = "SELECT * FROM MEDICINES WHERE ID=?";
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_SELECT);
            prepareStatement.setInt(1, id);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                medicine = new Medicine();
                medicine.setId(rs.getInt(1));
                medicine.setName(rs.getString(2));
                medicine.setBrand(rs.getString(3));
                medicine.setRegistryFDA(rs.getInt(4));
            }

        } catch (Exception e) {
            logger.error("SELECT medicine: ERROR, " + e.getMessage());
        }
        return medicine;
    }

    @Override
    public List<Medicine> searchAll() {
        List<Medicine> medicineList = new ArrayList();
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        Medicine medicine = null;
        try {
            String SQL_SELECTALL = "SELECT * FROM MEDICINES";
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_SELECTALL);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                medicine = new Medicine();
                medicine.setName(rs.getString(1));
                medicine.setBrand(rs.getString(2));
                medicine.setId(rs.getInt(3));
                medicine.setRegistryFDA(rs.getInt(4));
                medicineList.add(medicine);
            }

        } catch (Exception e) {
            logger.error("LIST ALL medicine: ERROR, " + e.getMessage());
        }
        return medicineList;
    }
}
