package com.grego.Final_Project_Refactor_clase24.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistDTO {
    private Integer dentist_id;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Last Name is required")
    private String lastName;
    @NotEmpty(message = "Register Number is required")
    private Integer register;

    public DentistDTO() {
    }

}
