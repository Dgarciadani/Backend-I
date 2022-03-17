package com.CTD;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BusinessDB {

    private static final Logger logger = Logger.getLogger(BusinessDB.class);

    /*2- Crear un statement para crear una tabla empleado con cinco columnas, la única obligatoria es ID que debe ser ademas PRIMARY KEY, las demas pueden elegirlas.
1- Debemos insertar tres filas con distintos datos, y una de ellas debe tener el ID repetido.
2- Verificar que nuestro log está mostrando este error(Como los id son primary keys al intentar insertar el mismo id, nos va a dar un error, loguear el error).
3- Actualizar a uno de los empleados, con un nuevo valor en alguna de las columnas y loguear con un objeto debug y toda la información del empleado.
4- Eliminar un empleado según el ID y loguear como un objeto info toda la información del empleado eliminado.
5- Eliminar otro empleado según otra columna, ej:email y loguear como un objeto info y loguear como un objeto info toda la información del empleado eliminado.

*/
    public static void main(String[] args) throws Exception {
        //EMPLOYEE AREA INSTANCE

        Employee employee1 = new Employee(1, 24, "pablo", "ventas", "22/02/21");
        Employee employee2 = new Employee(2, 20, "pablo2", "ventas", "22/02/21");
        Employee employee3 = new Employee(1, 50, "pablo4", "ventas", "22/02/21"); //ADD DUPLICATED ID intentionally


// QUERY STRINGS
        String initDB = "DROP TABLE IF EXISTS EMPRESA; CREATE TABLE EMPRESA( ID INT PRIMARY KEY NOT NULL," +
                "AGE INT NOT NULL," +
                " NAME  VARCHAR(255) NOT NULL, " +
                "LASTNAME VARCHAR(255) NOT NULL," +
                "FEHCA_INICIO VARCHAR(255) NOT NULL);";

        String insertValues1 =
                "INSERT INTO EMPRESA VALUES(" + employee1.getId() + ", " + employee1.getEdad() + " , '" + employee1.getName() + "', ' " + employee1.getLastName() + " ', '" + employee1.getFehcaInicio() + "');";
        String insertValues3 =
                "INSERT INTO EMPRESA VALUES(" + employee3.getId() + ", " + employee3.getEdad() + " , '" + employee3.getName() + "', ' " + employee3.getLastName() + " ', '" + employee3.getFehcaInicio() + "');";
        String insertValues2 =
                "INSERT INTO EMPRESA VALUES(" + employee2.getId() + ", " + employee2.getEdad() + " , '" + employee2.getName() + "', ' " + employee2.getLastName() + " ', '" + employee2.getFehcaInicio() + "');";

        String seeData = "SELECT * FROM EMPRESA";
        String alterEmployee = "UPDATE EMPRESA SET NAME = 'Manolito' WHERE ID = 2";
        String deleteEmployee = "DELETE FROM EMPRESA WHERE ID = 1";
        String deleteEmployee2 = "DELETE FROM EMPRESA WHERE NAME ='Manolito'";

        Connection conn = null;
        try {
            //STARTED CONNECTION
            logger.info("init Connection");
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement state = conn.createStatement();
            logger.info("Init Connection: SUCCESS");
            try {
                logger.info("init DB");
                state.execute(initDB);
                logger.info("init DB: SUCCESS");
            } catch (Exception e) {
                logger.error("init DB ERROR:" + e.getMessage());
            }
            try {
                logger.info("try to insert employee1 data");
                state.execute(insertValues1);
                logger.info("try to insert employee1 data: SUCCESS ");
            } catch (Exception e) {
                logger.error("insert data employee1 ERROR:" + e.getMessage());
            }
            try {
                logger.info("try to insert employee2 data");
                state.execute(insertValues2);
                logger.info("try to insert employee1 data: SUCCESS ");
            } catch (Exception e) {
                logger.error("insert data employee2 ERROR:" + e.getMessage());
            }
            try {
                logger.info("try to insert employee3 data");
                state.execute(insertValues3);
                logger.info("try to insert employee1 data: SUCCESS ");
            } catch (Exception e) {
                logger.error("insert data employee3 ERROR:" + e.getMessage());
            }
            try {
                logger.info("Show Table Data init");
                ResultSet rs = state.executeQuery(seeData);
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " - " + rs.getInt(2) + " - " + rs.getString(3) + " - " + rs.getString(4) + " - " + rs.getString(5));
                }
                logger.debug(rs);
            } catch (Exception e) {
                logger.error("Show Table Data: ERROR" + e.getMessage());
            }
            try {
                logger.info("update data employee started");
                state.execute(alterEmployee);
                logger.info("update data employee: SUCCESS");
            } catch (Exception e) {
                logger.error("update data employee ERROR: " + e);
            }
            try {
                logger.info("Show Table Data init");
                ResultSet rs = state.executeQuery("SELECT * FROM EMPRESA WHERE ID=2");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " - " + rs.getInt(2) + " - " + rs.getString(3) + " - " + rs.getString(4) + " - " + rs.getString(5));
                }
                logger.debug(rs);
            } catch (Exception e) {
                logger.error("Show Table Data: ERROR" + e.getMessage());
            }
            try {
                logger.info("Delete employee by ID init");
                logger.debug(state.executeQuery("SELECT * FROM EMPRESA WHERE ID=1"));
                state.execute(deleteEmployee);
                logger.info("Delete employee by ID: SUCCESS");
            } catch (Exception e) {
                logger.error("Delete employee by ID ERROR: " + e);
            }
            try {
                logger.info("Delete employee by Name");
                logger.debug(state.executeQuery("SELECT * FROM EMPRESA WHERE NAME = 'Manolito'"));
                state.execute(deleteEmployee2);
                logger.info("Delete employee by Name: SUCCESS");
            } catch (Exception e) {
                logger.error("Delete employee by Name: ERROR" + e.getMessage());
            }
        } catch (Exception e) {
            logger.error("Set connection ERROR: " + e.getMessage());
        } finally {
            conn.close();
            logger.info("Connection closed");
        }


       /* try {
            logger.info(" init DB");
            state.execute(initDB);
        } catch (Exception e) {
            logger.error("Stat DB: failure: " + e);
        }
        try {
            logger.info("add data to database started");
            state.execute(insertValues1);
            ResultSet rs = state.executeQuery(seeData);
            System.out.println(rs.getInt(1) + " - " + rs.getInt(2) + " - " + rs.getString(3) + " - " + rs.getString(4) + " - " + rs.getString(5));
        } catch (Exception e) {
            logger.error("add data to database failure: " +
                    e);
        }
        try {
            logger.info("update employee data started");
            state.execute(alterEmployee);
            state.executeQuery(seeData);
        } catch (Exception e) {
            logger.error("Update data employee: Error: " + e);
        }
        ;*/
    }

}
