package com.grego.Final_Project_Refactor_clase24.util;

public class UtilDate {
    public static java.sql.Date utilDateToSQLDate(java.util.Date utilDate) {
        long miliseconds = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(miliseconds);
        return sqlDate;
    }

}
