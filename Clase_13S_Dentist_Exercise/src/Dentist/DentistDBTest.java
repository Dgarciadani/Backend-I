package Dentist;

import org.apache.log4j.Logger;

import java.sql.*;

/*
Crear una entidad Odontologos en la base de datos H2 que tenga los siguientes campos:
        apellido: String
        nombre: String
        matricula: String
        Para ello, te pedimos crear una connection a la base de datos e insertar una fila sobre la tabla odontólogos
         y luego hacer un update que le cambie la matrícula. Finalmente, no te olvidés corroborar
         con una consulta la inserción y la modificación.
*/

public class DentistDBTest {
    private static final Logger logger = Logger.getLogger(DentistDBTest.class);
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS Odontologo;" +
            "CREATE TABLE Odontologo(Name VARCHAR(255) NOT NULL," +
            "LastName VARCHAR(255) NOT NULL," +
            "Registry VARCHAR(255) PRIMARY KEY NOT NULL);";

    private static final String SQL_INSERT = "INSERT INTO Odontologo VALUES(?,?,?);";
    private static final String SQL_UPDATE = "UPDATE Odontologo SET Registry=? WHERE Name=?";
    private static final String SQL_SELECT = "SELECT * FROM Odontologo";

    public static void main(String[] args) throws Exception {
        Dentist dentist = new Dentist("pepe", "lopez", "Dt-001");
        Class.forName("org.h2.Driver");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement state = conn.createStatement();
            state.execute(SQL_CREATE_TABLE);
            logger.info("Create Table: SUCCESS");

            try {
                conn.setAutoCommit(false);
                PreparedStatement insert_statement = conn.prepareStatement(SQL_INSERT);
                insert_statement.setString(1, dentist.getName());
                insert_statement.setString(2, dentist.getLastName());
                insert_statement.setString(3, dentist.getRegistry());
                insert_statement.execute();
                conn.commit();
                conn.setAutoCommit(true);
                logger.info("Inser dentist data: SUCCES");
            } catch (Exception e) {
                logger.error("Dentist Insert data: ERROR, " + e.getMessage());
                if (conn != null) {
                    conn.rollback();
                    logger.info("Dentist Insert data: ERROR, do Rollback ");
                }
            }
            try {
                conn.setAutoCommit(false);
                PreparedStatement update_statement = conn.prepareStatement(SQL_UPDATE);
                update_statement.setString(1, "CAMBIADO");
                update_statement.setString(2, "pepe");
                update_statement.execute();
                conn.commit();
                conn.setAutoCommit(true);
                logger.info("Update dentist data: SUCCESS");
            } catch (Exception e) {
                logger.error("Update dentist data: ERROR, " + e.getMessage());
                if (conn != null) {
                    conn.rollback();
                    logger.info("Update dentist data: ERROR, do Rollback");
                }
            }
            try {
                ResultSet rs = state.executeQuery(SQL_SELECT);
                while (rs.next()) {
                    System.out.println(rs.getString(1)+ " - "+rs.getString(2)+" - "+rs.getString(3));
                }
            }catch (Exception e) {
                logger.error("Get dentist data: ERROR, "+ e.getMessage());
            }

        } catch (Exception e) {
            logger.error("Conn ERROR, " + e.getMessage());
        } finally {
            conn.close();
            logger.info("Conection closed");
        }

    }
}
