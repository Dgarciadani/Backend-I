package com.example.Clase_23_SpringWeb_MVC_Thymeleaf_H2_Patient_Exercise.service;


import com.example.Clase_23_SpringWeb_MVC_Thymeleaf_H2_Patient_Exercise.domain.Address;
import com.example.Clase_23_SpringWeb_MVC_Thymeleaf_H2_Patient_Exercise.domain.Patient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientService {
    private static List<Patient> patientsList = new ArrayList();


    public static Patient createPatient(int patient_id, String name, String lastName, String email, int dni, int address_id, String street, int door, String locality, String state) {
        Address address = new Address(address_id, street, door, locality, state);
        Patient patient = new Patient(patient_id, name, lastName, email, dni, new Date(), address);
        patientsList.add(patient);
        return patient;
    }

    public static List<Patient> getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(List<Patient> patientsList) {
        PatientService.patientsList = patientsList;
    }

    public static Patient searchPatient(String mail) {
        Patient patientS = null;
        for (Patient patient : patientsList) {
            if (patient.getEmail() == mail) {
                patientS = patient;
            }
        }
        return patientS;
    }
}

