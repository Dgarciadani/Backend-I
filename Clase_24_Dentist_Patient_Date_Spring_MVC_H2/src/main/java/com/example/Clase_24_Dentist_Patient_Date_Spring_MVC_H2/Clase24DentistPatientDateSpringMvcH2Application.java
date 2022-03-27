package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Dentist;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.impl.DentistDaoH2;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services.DentistService;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Clase24DentistPatientDateSpringMvcH2Application {

	public static void main(String[] args) {
		SpringApplication.run(Clase24DentistPatientDateSpringMvcH2Application.class, args);
	}

}
