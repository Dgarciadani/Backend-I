package com.grego.Final_Project_Refactor_clase24.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grego.Final_Project_Refactor_clase24.domain.Address;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class PatientDTO {
    @NotEmpty(message = "The name is required")
    private String name;
    @NotEmpty(message = "The last name is required")
    private String lastName;
    @NotEmpty(message = "The Dni is required")
    private Integer dni;
    @OneToOne(mappedBy = "patient", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AddressDTO address;

    public PatientDTO() {
    }
}

