package Entities;

import java.util.Date;

public class Patient {
    private int id;
    private String name;
    private String lastname;
    private int DNI;
    private Date DateInit;
    private Address address;

    public Patient(String name, String lastname, int DNI, Date dateInit, Address address) {
        this.name = name;
        this.lastname = lastname;
        this.DNI = DNI;
        DateInit = dateInit;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public Date getDateInit() {
        return DateInit;
    }

    public void setDateInit(Date dateInit) {
        DateInit = dateInit;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
