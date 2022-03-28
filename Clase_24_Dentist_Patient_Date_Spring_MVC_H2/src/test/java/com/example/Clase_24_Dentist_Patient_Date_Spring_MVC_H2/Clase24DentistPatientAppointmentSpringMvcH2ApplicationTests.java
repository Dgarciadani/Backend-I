package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Dentist;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.impl.DentistDaoH2;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services.DentistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Clase24DentistPatientAppointmentSpringMvcH2ApplicationTests {

	@Test
	public void createDentists(){
		DentistService dentistService = new DentistService(new DentistDaoH2());
		Dentist dentist = new Dentist("Pablo","Perez",32424);
		Assertions.assertTrue(dentistService.register(dentist).getDentist_id()>=1);
	}
}
