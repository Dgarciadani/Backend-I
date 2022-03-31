package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistDTO {
    private String fullName;
    private Integer registerNumber;

    public DentistDTO(String fullName, Integer registerNumber) {
        this.fullName = fullName;
        this.registerNumber = registerNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(Integer registerNumber) {
        this.registerNumber = registerNumber;
    }
}
