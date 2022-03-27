package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.impl;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Address;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.Idao;

import java.util.List;

public class AddressDaoH2 implements Idao<Address> {


    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URl = "jdbc:h2:~/test";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    @Override
    public Address register(Address address) {
        return null;
    }

    @Override
    public Address search(int id) {
        return null;
    }

    @Override
    public Address update(int id, Address address) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Address> searchAll() {
        return null;
    }
}
