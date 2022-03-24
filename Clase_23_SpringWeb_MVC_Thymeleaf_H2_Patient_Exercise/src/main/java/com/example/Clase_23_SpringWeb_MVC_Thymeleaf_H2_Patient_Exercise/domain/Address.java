package com.example.Clase_23_SpringWeb_MVC_Thymeleaf_H2_Patient_Exercise.domain;

public class Address {
    private int id;
    private String street;
    private int door;
    private String locality;
    private String state;

    public Address(int id, String street, int door, String locality, String state) {
        this.id = id;
        this.street = street;
        this.door = door;
        this.locality = locality;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
