package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.util;

public class UtilDate {
    public static java.sql.Date utilDateToSQLDate(java.util.Date utilDate) {
        long miliseconds = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(miliseconds);
        return sqlDate;
    }

}
