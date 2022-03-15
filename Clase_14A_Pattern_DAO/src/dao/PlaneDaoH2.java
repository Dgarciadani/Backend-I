package dao;

import entities.Plane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlaneDaoH2 implements IDao<Plane> {
    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URl = "jdbc:h2:~/Planes";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    public PlaneDaoH2() {
    }

    @Override
    public Plane register(Plane plane) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_INSERT = "INSERT INTO PLANES VALUES(?,?,?,?,?)";
        try {
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_INSERT);
            prepareStatement.setString(1, plane.getBrand());
            prepareStatement.setString(2, plane.getModel());
            prepareStatement.setString(3, plane.getRegistry());
            prepareStatement.setString(4, plane.getStartDate());
            prepareStatement.setLong(5, plane.getId());
            prepareStatement.executeUpdate();
            prepareStatement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return plane;
    }

    @Override
    public void delete(Long id) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_DELETE = "DELETE FROM PLANES WHERE ID=?";
        try {
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_DELETE);
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
            prepareStatement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Plane search(Long id) {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_SELECT = "SELECT * FROM PLANES WHERE ID=?";
        Plane plane = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_SELECT);
            prepareStatement.setLong(1, id);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                plane = new Plane();
                plane.setBrand(rs.getString(1));
                plane.setModel(rs.getString(2));
                plane.setRegistry(rs.getString(3));
                plane.setStartDate(rs.getString(4));
                plane.setId(rs.getLong(5));
            }

            prepareStatement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(plane.getId());
        return plane;
    }

    @Override
    public List<Plane> findAll() {
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_SELECTALL = "SELECT * FROM PLANES";
        List<Plane> planeList = new ArrayList();
        try {
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            prepareStatement = conn.prepareStatement(SQL_SELECTALL);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Plane plane = new Plane();
                plane.setBrand(rs.getString(1));
                plane.setModel(rs.getString(2));
                plane.setRegistry(rs.getString(3));
                plane.setStartDate(rs.getString(4));
                plane.setId(rs.getLong(5));
                planeList.add(plane);

            }
            prepareStatement.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return planeList;
    }
}

