import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {
    public static void main(String[] args) throws Exception {
        //SELECT H2 DRIVER
        Class.forName("org.h2.Driver");//.newInstance(); No Usable
        //CREATE CONNECTION
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        Statement state = conn.createStatement();
        //CREATE QUERY STRING TO EXECUTE
        String createTable = "DROP TABLE IF EXISTS TEST; CREATE TABLE TEST(ID INT PRIMARY KEY not null, NAME VARCHAR(255) not null)";
        //EXECUTE THE QUERY
        state.execute(createTable);
        //INSERT VALUES INTO TABLE
        String insertFila = "INSERT INTO TEST(ID,NAME) VALUES(1,'HOLA')";
        String insertFila2 = "INSERT INTO TEST VALUES(2,'CHAU')";
        state.execute(insertFila);
        state.execute(insertFila2);
        // SHOW DATA INTO TABLE
        String obtenerData = "SELECT * FROM TEST";
        ResultSet rs = state.executeQuery(obtenerData);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " - " + rs.getString(2));
        }
    }
}
