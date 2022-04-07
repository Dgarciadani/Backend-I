package com.grego.Final_Project_Refactor_clase24.services;

import com.grego.Final_Project_Refactor_clase24.domain.Patient;
import com.grego.Final_Project_Refactor_clase24.dto.PatientDTO;

import java.util.List;

public interface IPatientService {
public PatientDTO getPatient(Integer id);
public Patient savePatient(Patient patient);
public void deletePatient(Integer id);
public List<PatientDTO> getAllPatients();
}
