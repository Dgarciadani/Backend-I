package com.grego.Final_Project_Refactor_clase24.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grego.Final_Project_Refactor_clase24.domain.Patient;
import com.grego.Final_Project_Refactor_clase24.dto.PatientDTO;
import com.grego.Final_Project_Refactor_clase24.repository.PatientRepository;
import com.grego.Final_Project_Refactor_clase24.services.IPatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ModelMapper modelmapper;


    @Override
    public PatientDTO findById(Integer id) {
        return patientRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public PatientDTO save(PatientDTO entity) {
        Patient patient = mapToEntity(entity);
        patient = patientRepository.save(patient);
        return mapToDTO(patient);
    }

    @Override
    public void deleteById(Integer id) {
        patientRepository.findById(id).ifPresent(patientRepository::delete);
    }

    @Override
    public PatientDTO update(Integer id, PatientDTO entity) {
        Patient patient = mapToEntity(entity);
        patient.setPatient_id(id);
        patient = patientRepository.save(patient);
        return mapToDTO(patient);
    }

    @Override
    public List<PatientDTO> findAll() {
        return patientRepository.findAll().stream().map(this::mapToDTO).collect(java.util.stream.Collectors.toList());
    }

    public List<PatientDTO> findByName(String name) {
        return patientRepository.findByName(name).stream().map(this::mapToDTO).collect(java.util.stream.Collectors.toList());
    }
/*    public PatientDTO getPatient(Integer id) {
        PatientDTO patientDTO = null;
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            patientDTO = objectMapper.convertValue(patient.get(), PatientDTO.class);

        }
        return patientDTO;
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Integer id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            patientRepository.deleteById(id);
        }
    }


    public List<PatientDTO> getAllPatients() {
        return null;
    }*/

    //-----Mapper-----
    public PatientDTO mapToDTO(Patient patient) {
        return modelmapper.map(patient, PatientDTO.class);
    }

    public Patient mapToEntity(PatientDTO patientDTO) {
        return modelmapper.map(patientDTO, Patient.class);
    }


}
