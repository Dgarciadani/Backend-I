package com.grego.Final_Project_Refactor_clase24;

import com.grego.Final_Project_Refactor_clase24.dto.AddressDTO;
import com.grego.Final_Project_Refactor_clase24.dto.AppointmentDTO;
import com.grego.Final_Project_Refactor_clase24.dto.DentistDTO;
import com.grego.Final_Project_Refactor_clase24.dto.PatientLongDTO;
import com.grego.Final_Project_Refactor_clase24.services.impl.AppointmentService;
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
    @Autowired
    AppointmentService appointmentService;

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
        PatientLongDTO patientdto = new PatientLongDTO();
        patientdto.setName("Pedro");
        patientdto.setLastName("Perez");
        AddressDTO address = new AddressDTO();
        address.setCity("Ciudad");
        address.setStreet("Calle");
        address.setDoor(123);
        address.setState("Estado");
        patientdto.setAddress(address);
        patientdto.setDni(123456789);
        patientdto.setDateInit(new java.sql.Date(new java.util.Date().getTime()));
        patientService.save(patientdto);
    }

    @Test
    public void saveAppointment() {
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        PatientLongDTO patient = new PatientLongDTO();
        patient.setPatient_id(1);
        DentistDTO dentist = new DentistDTO();
        dentist.setDentist_id(1);
        appointmentDTO.setPatient(patient);
        appointmentDTO.setDentist(dentist);
        appointmentDTO.setDate(new java.sql.Date(new java.util.Date().getTime()));
        appointmentService.save(appointmentDTO);
    }
}
