package com.grego.Final_Project_Refactor_clase24.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistDTO {

    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Last Name is required")
    private String lastName;

    private Integer register;

    public DentistDTO() {
    }

}
