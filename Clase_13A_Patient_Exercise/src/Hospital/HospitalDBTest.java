package Hospital;

import org.apache.log4j.Logger;

import java.sql.*;

public class HospitalDBTest {

    private static final Logger logger = Logger.getLogger(HospitalDBTest.class);

    //SQL QUERY STRINGS
    static String sql_create_table = "DROP TABLE IF EXISTS PATIENT;" +
            "CREATE TABLE PATIENT(" +
            "NAME VARCHAR(255) NOT NULL," +
            "LASTNAME VARCHAR(255) NOT NULL," +
            "ADDRESS VARCHAR(255) NOT NULL," +
            "DNI INT  PRIMARY KEY NOT NULL," +
            "STARTDATE VARCHAR(255) NOT NULL," +
            "USER_PATIENT VARCHAR(50) NOT NULL," +
            "PASS VARCHAR(50) NOT NULL);";

    static String sql_add_patient = "INSERT INTO PATIENT VALUES(?,?,?,?,?,?,?);";
    static String sql_update_patient = "UPDATE PATIENT SET PASS=? WHERE DNI = ?;";
    static String sql_query_patient = "SELECT * FROM PATIENT;";

    public static void main(String[] args) throws Exception {
        //SET PATIENT EJ
        Patient patient1 = new Patient("manolito", "garcia", "calle falsa 123", 40834293, "22/04/21", "manolo777", "mypass");


        Connection conn = null;

        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement statement = conn.createStatement();
            statement.execute(sql_create_table);
            try {
                logger.info("try to set patient data init");
                PreparedStatement ps_insertPatient = conn.prepareStatement(sql_add_patient);

                //SET PS
                ps_insertPatient.setString(1, patient1.getName());
                ps_insertPatient.setString(2, patient1.getLastName());
                ps_insertPatient.setString(3, patient1.getAddress());
                ps_insertPatient.setInt(4, patient1.getDni());
                ps_insertPatient.setString(5, patient1.getStartDate());
                ps_insertPatient.setString(6, patient1.getUser());
                ps_insertPatient.setString(7, patient1.getPass());

                //EXECUTE PS QUERY
                ps_insertPatient.execute();
                logger.info("set patient data: SUCCESS");

            } catch (Exception e) {
                logger.error("Set patient data: ERROR, " + e.getMessage());
            }
            try {
                logger.info("try to update patient data init");
                //START TX
                conn.setAutoCommit(false);

                PreparedStatement ps_updatePatient = conn.prepareStatement(sql_update_patient);

                ps_updatePatient.setString(1, "NOmypass");
                ps_updatePatient.setInt(2, patient1.getDni());

                ps_updatePatient.execute();
                logger.info("update patient data: SUCCESS");

                conn.commit();
                conn.setAutoCommit(true);

            } catch (SQLException e1) {
                logger.error("update patient data: ERROR, " + e1.getMessage());
                if (conn != null) {
                    conn.rollback();
                    logger.info("rollback to previous state");
                } else {
                    logger.info("CONNECTION NON CREATED, NO ROLLBACK ");
                }
            }
            try {
                ResultSet rs = statement.executeQuery(sql_query_patient);
                while (rs.next()) {
                    System.out.println(rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4) + " - " + rs.getString(5) + " - " + rs.getString(6) + " - " + rs.getString(7));
                }
            } catch (Exception e) {
                logger.error("sql query select: ERROR, " + e.getMessage());
            }

        } catch (Exception e) {
            logger.error("try to set connection: ERROR, " + e.getMessage());
        } finally {
            conn.close();
            logger.info("connection closed");
        }
    }
}
