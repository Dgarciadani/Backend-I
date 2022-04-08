package com.grego.Final_Project_Refactor_clase24.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class PatientLongDTO {

    @JsonBackReference
    private Integer patient_id;

    private String name;
    private String lastName;
    private Integer dni;
    @OneToOne(mappedBy = "patient", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AddressDTO address;

    private Date dateInit;

    public PatientLongDTO() {
    }


}

