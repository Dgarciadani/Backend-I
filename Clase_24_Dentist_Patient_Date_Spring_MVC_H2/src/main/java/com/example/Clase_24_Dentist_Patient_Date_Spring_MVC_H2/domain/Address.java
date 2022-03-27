package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain;

public class Address {
    private int addressId;
    private String street;
    private int door;
    private String city;
    private String state;

    public Address(int addressId, String street, int door, String city, String state) {
        this.addressId = addressId;
        this.street = street;
        this.door = door;
        this.city = city;
        this.state = state;
    }

    public Address(String street, int door, String city, String state) {
        this.street = street;
        this.door = door;
        this.city = city;
        this.state = state;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
