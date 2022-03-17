package Util;

public class Date {

    public static java.sql.Date utilDateToSQLDate(java.util.Date utilDate) {
        long miliseconds = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(miliseconds);
        return sqlDate;

    }
//tutor Example
   /* public static java.sql.Date utilDateToSqlDate(java.util.Date utilDate){
        long timeInMilliSeconds = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(timeInMilliSeconds);
        return sqlDate;
    }*/


}
