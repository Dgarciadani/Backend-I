package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.impl;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Patient;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.Idao;

import java.util.List;

public class PatientDaoH2 implements Idao<Patient> {


    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URl = "jdbc:h2:~/test";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";


    @Override
    public Patient register(Patient patient) {
        return null;
    }

    @Override
    public Patient search(int id) {
        return null;
    }

    @Override
    public Patient update(int id, Patient patient) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Patient> searchAll() {
        return null;
    }
}
