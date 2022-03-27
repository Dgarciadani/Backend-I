package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.impl;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Appointment;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.Idao;


import java.util.List;

public class AppointmentDaoH2 implements Idao<Appointment> {

    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URl = "jdbc:h2:~/test";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    @Override
    public Appointment register(Appointment appointment) {
        return null;
    }

    @Override
    public Appointment search(int id) {
        return null;
    }

    @Override
    public Appointment update(int id, Appointment appointment) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Appointment> searchAll() {
        return null;
    }
}
