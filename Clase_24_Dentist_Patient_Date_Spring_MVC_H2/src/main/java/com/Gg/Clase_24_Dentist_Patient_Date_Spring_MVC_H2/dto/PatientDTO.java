package com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class PatientDTO {
    private String fullName;
    private Integer dni;
    private String address;
    private String date;

    public PatientDTO(String fullName, Integer dni, String address, String date) {
        this.fullName = fullName;
        this.dni = dni;
        this.address = address;
        this.date = date;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

