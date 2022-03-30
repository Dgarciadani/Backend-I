package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain;

public class Address {
    private Integer addressId;
    private String street;
    private Integer door;
    private String city;
    private String state;

    public Address(Integer addressId, String street, Integer door, String city, String state) {
        this.addressId = addressId;
        this.street = street;
        this.door = door;
        this.city = city;
        this.state = state;
    }

    public Address(String street, Integer door, String city, String state) {
        this.street = street;
        this.door = door;
        this.city = city;
        this.state = state;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getDoor() {
        return door;
    }

    public void setDoor(Integer door) {
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
