package com.example.Clase_23_SpringWeb_MVC_Thymeleaf_H2_Patient_Exercise.domain;

import java.util.Date;

public class Patient {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private int dni;
    private Date dateInit;
    private Address address;

    public Patient(int id, String name, String lastName, String email, int dni, Date dateInit, Address address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.dni = dni;
        this.dateInit = dateInit;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getDateInit() {
        return dateInit;
    }

    public void setDateInit(Date dateInit) {
        this.dateInit = dateInit;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
