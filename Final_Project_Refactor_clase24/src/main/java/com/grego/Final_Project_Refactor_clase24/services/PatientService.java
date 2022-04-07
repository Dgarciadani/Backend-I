package com.grego.Final_Project_Refactor_clase24.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grego.Final_Project_Refactor_clase24.domain.Patient;
import com.grego.Final_Project_Refactor_clase24.dto.PatientDTO;
import com.grego.Final_Project_Refactor_clase24.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public PatientDTO getPatient(Integer id) {
        PatientDTO patientDTO = null;
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            patientDTO = objectMapper.convertValue(patient.get(), PatientDTO.class);

        }
        return patientDTO;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Integer id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            patientRepository.deleteById(id);
        }
    }


    @Override
    public List<PatientDTO> getAllPatients() {
        return null;
    }
}
