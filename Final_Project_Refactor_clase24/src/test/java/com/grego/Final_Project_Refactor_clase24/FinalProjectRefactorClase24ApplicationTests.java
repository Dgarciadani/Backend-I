package com.grego.Final_Project_Refactor_clase24;

import com.grego.Final_Project_Refactor_clase24.dto.DentistDTO;
import com.grego.Final_Project_Refactor_clase24.services.impl.DentistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FinalProjectRefactorClase24ApplicationTests {

    @Autowired
    DentistService dentistService;

    @Test
    public void saveDentist() {
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Dentist");
        dentistDTO.setLastName("Dentist");
        dentistDTO.setRegister(465465);
        dentistService.save(dentistDTO);

        Assertions.assertNotNull(dentistService.findById(1));

    }
}
