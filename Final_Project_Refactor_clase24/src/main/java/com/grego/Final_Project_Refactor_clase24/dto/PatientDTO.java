package com.grego.Final_Project_Refactor_clase24.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grego.Final_Project_Refactor_clase24.domain.Address;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class PatientDTO {
    @NotEmpty(message = "The name is required")
    private String name;
    @NotEmpty(message = "The last name is required")
    private String lastName;
    @NotEmpty(message = "Address is required")
    private Address address;
    @NotEmpty(message= "The Dni is required")
    private Integer dni;
    @NotEmpty(message = "The date is required")
    private Date dateInit;

    public PatientDTO() {
    }
}

