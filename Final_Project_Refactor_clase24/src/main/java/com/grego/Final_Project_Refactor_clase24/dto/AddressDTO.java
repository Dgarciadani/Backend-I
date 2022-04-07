package com.grego.Final_Project_Refactor_clase24.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grego.Final_Project_Refactor_clase24.domain.Patient;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDTO {


    @NotEmpty(message = "Street cannot be empty")
    private String street;
    @NotEmpty(message = "Door cannot be empty")
    private Integer door;
    @NotEmpty(message = "City cannot be empty")
    private String city;
    @NotEmpty(message = "State cannot be empty")
    private String state;
    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private PatientDTO patient;

    public AddressDTO() {
    }
}
