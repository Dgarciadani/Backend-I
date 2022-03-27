package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain;


import java.util.Date;

public class Patient {
    private int patient_id;
    private String name;
    private String lastName;
    private Address address;
    private int dni;
    private Date dateInit;

    public Patient(int patient_id, String name, String lastName, Address address, int dni, Date dateInit) {
        this.patient_id = patient_id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.dni = dni;
        this.dateInit = dateInit;
    }

    public Patient(String name, String lastName, Address address, int dni, Date dateInit) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.dni = dni;
        this.dateInit = dateInit;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + patient_id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", dni=" + dni +
                ", dateInit=" + dateInit +
                '}';
    }
}
