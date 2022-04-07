package com.grego.Final_Project_Refactor_clase24.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class DentistDTO {

    private String name;
    private String lastName;
    private Integer register;

    public DentistDTO() {
    }

}
