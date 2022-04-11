package com.grego.Final_Project_Refactor_clase24.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentDTO {

    private PatientDTO patient;

    private DentistDTO dentist;


    private Date date;


    public AppointmentDTO() {

    }
}
