package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Address;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Appointment;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Dentist;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Patient;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.impl.AppointmentDaoH2;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.impl.DentistDaoH2;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.impl.PatientDaoH2;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services.AppointmentService;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services.DentistService;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services.PatientService;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

@SpringBootTest
class Clase24DentistPatientAppointmentSpringMvcH2ApplicationTests {


    public static boolean beforeAll() {
        boolean conn = false;
        String DB_JDBC_DRIVER = "org.h2.Driver";
        String DB_URl = "jdbc:h2:~/test";
        String DB_USER = "sa";
        String DB_PASS = "";

        try {
            Class.forName(DB_JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            if (connection != null) {
                conn = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    @Test
    public void createDentists() {
        DentistService dentistService = new DentistService(new DentistDaoH2());
        Dentist dentist = new Dentist("Pablo", "Perez", 32424);
        Assertions.assertTrue(dentistService.register(dentist).getDentist_id() >= 1 && beforeAll());
    }

    @Test
    public void searchDentist() {
        DentistService dentistService = new DentistService(new DentistDaoH2());
        Dentist dentist = dentistService.search(7);
        Assertions.assertEquals("Pablo", dentist.getName());
    }

    @Test
    public void updateDentist() {
        DentistService dentistService = new DentistService(new DentistDaoH2());
        Dentist dentist = new Dentist("Juani", "Mrtin", 629);
        dentistService.update(7, dentist);
        Assertions.assertTrue(dentistService.search(2).getName().equals("Juani") && beforeAll());
    }

    @Test
    public void deleteDentist() {
        DentistService dentistService = new DentistService(new DentistDaoH2());
        dentistService.delete(9);
        Assertions.assertTrue(dentistService.search(5) == null && beforeAll());
    }

    @Test
    public void registerPatient() {
        PatientService patientService = new PatientService(new PatientDaoH2());
        Address address = new Address("siempre viva", 3423, "Rio Cuarto", "Cordoba");
        Patient patient = new Patient("Carlos", "Baute", address, 1234567, new Date());
        Assertions.assertTrue(patientService.register(patient).getPatient_id() >= 1 && beforeAll());

    }

    @Test
    public void searchPatient() {
        PatientService patientService = new PatientService(new PatientDaoH2());
        Patient patient = patientService.search(2);
        Assertions.assertEquals("Paciente", patient.getName());
        Assertions.assertTrue(patient.getAddress().getCity().equals("Cordoba"));

    }

    @Test
    public void updatePatient() {
        int idExample = 2;
        PatientService patientService = new PatientService(new PatientDaoH2());
        Address address = new Address(idExample, "siempre muerta", 3423, "BA", "BSAS");
        Patient patient = new Patient("Paciente", "guerra", address, 1234567, new Date());
        patientService.update(idExample, patient);
        Assertions.assertTrue(patientService.search(idExample).getLastName().equals("guerra"));
        Assertions.assertTrue(patientService.search(idExample).getAddress().getState().equals("BSAS"));


    }

    @Test
    public void deletePatient() {
        PatientService patientService = new PatientService(new PatientDaoH2());
        patientService.delete(3);
        Assertions.assertTrue(patientService.search(3) == null && beforeAll());


    }

    @Test
    public void searchAllPatients() {
        PatientService patientService = new PatientService(new PatientDaoH2());
        Assertions.assertTrue(patientService.searchAll().size() >= 1);
        Assertions.assertTrue(patientService.searchAll().get(0).getName().equals("Paciente"));

    }

    @Test
    public void registerAppointment() {
        AppointmentService appointmentService = new AppointmentService(new AppointmentDaoH2());
        PatientService patientService = new PatientService(new PatientDaoH2());
        DentistService dentistService = new DentistService(new DentistDaoH2());
        Patient patient = patientService.search(2);
        Dentist dentist = dentistService.search(2);
        Appointment appointment = new Appointment(dentist, patient, new Date());
        System.out.println(appointment.toString());
        Assertions.assertTrue(appointmentService.register(appointment).getAppointment_id() >= 1 && beforeAll());

    }

    @Test
    public void searchAppointment() {
        AppointmentService appointmentService = new AppointmentService(new AppointmentDaoH2());
        Appointment appointment = appointmentService.search(3);
        Assertions.assertEquals("Pablo", appointment.getDentist().getName());
        Assertions.assertEquals("Paciente", appointment.getPatient().getName());
        Assertions.assertEquals("Pablo", appointment.getDentist().getName());
        Assertions.assertEquals("BA", appointment.getPatient().getAddress().getCity());
    }

    @Test
    public void updateAppointment() {
        AppointmentService appointmentService = new AppointmentService(new AppointmentDaoH2());
        Appointment appointment = new Appointment(new Dentist(2, "Pablo", "Mrtin", 629), new Patient(2, "Paciente", "guerra", new Address(2, "siempre muerta", 3423, "BA", "BSAS"), 1234567, new Date()), new Date());
        appointmentService.update(3, appointment);
        Assertions.assertTrue(appointmentService.search(3).getDentist().getName().equals("Pablo") && beforeAll());
        Assertions.assertTrue(appointmentService.search(3).getPatient().getName().equals("Paciente") && beforeAll());
        Assertions.assertTrue(appointmentService.search(3).getDentist().getName().equals("Pablo") && beforeAll());
        Assertions.assertTrue(appointmentService.search(3).getPatient().getAddress().getCity().equals("BA") && beforeAll());

    }

    @Test
    public void deleteAppointment() {
        AppointmentService appointmentService = new AppointmentService(new AppointmentDaoH2());
        appointmentService.delete(2);
        Assertions.assertTrue(appointmentService.search(2) == null && beforeAll());

    }

    @Test
    public void searchAllAppointments() {
        AppointmentService appointmentService = new AppointmentService(new AppointmentDaoH2());
        Assertions.assertTrue(appointmentService.searchAll().size() >= 1);


    }

}
