package com.grego.Final_Project_Refactor_clase24.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grego.Final_Project_Refactor_clase24.domain.Dentist;
import com.grego.Final_Project_Refactor_clase24.domain.Patient;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentDTO {


    private Dentist dentist;
    private Patient patient;
    @NotEmpty(message = "The date can not be empty")
    private Date date;


    public AppointmentDTO() {
    }
}
