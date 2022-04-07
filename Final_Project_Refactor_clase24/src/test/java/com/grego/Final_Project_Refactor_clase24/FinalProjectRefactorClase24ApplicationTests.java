package com.grego.Final_Project_Refactor_clase24;

import com.grego.Final_Project_Refactor_clase24.domain.Address;
import com.grego.Final_Project_Refactor_clase24.domain.Patient;
import com.grego.Final_Project_Refactor_clase24.dto.AddressDTO;
import com.grego.Final_Project_Refactor_clase24.dto.DentistDTO;
import com.grego.Final_Project_Refactor_clase24.dto.PatientDTO;
import com.grego.Final_Project_Refactor_clase24.services.impl.DentistService;
import com.grego.Final_Project_Refactor_clase24.services.impl.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FinalProjectRefactorClase24ApplicationTests {

    @Autowired
    DentistService dentistService;
    @Autowired
    PatientService patientService;

    @Test
    public void saveDentist() {
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Dentist");
        dentistDTO.setLastName("Dentist");
        dentistDTO.setRegister(465465);
        dentistService.save(dentistDTO);

        Assertions.assertNotNull(dentistService.findById(1));

    }

    @Test
    public void savePatient() {
        PatientDTO patientdto = new PatientDTO();
        patientdto.setName("JuanListo");
        patientdto.setLastName("Perez");
        AddressDTO address = new AddressDTO();
        address.setCity("Ciudad");
        address.setStreet("Calle");
        address.setDoor(123);
        address.setState("Estado");
        patientdto.setAddress(address);
        patientdto.setDni(123456789);
        patientService.save(patientdto);
    }
}
