package com.grego.Final_Project_Refactor_clase24.services.impl;

import com.grego.Final_Project_Refactor_clase24.domain.Patient;
import com.grego.Final_Project_Refactor_clase24.dto.PatientLongDTO;
import com.grego.Final_Project_Refactor_clase24.repository.PatientRepository;
import com.grego.Final_Project_Refactor_clase24.services.IPatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ModelMapper modelmapper;


    @Override
    public PatientLongDTO findById(Integer id) {
        return patientRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public PatientLongDTO save(PatientLongDTO entity) {
        Patient patient = mapToEntity(entity);
        patient = patientRepository.save(patient);
        return mapToDTO(patient);
    }

    @Override
    public void deleteById(Integer id) {
        patientRepository.findById(id).ifPresent(patientRepository::delete);
    }

    @Override
    public PatientLongDTO update(Integer id, PatientLongDTO entity) {
        Patient patient = mapToEntity(entity);
        patient.setPatient_id(id);
        patient = patientRepository.save(patient);
        return mapToDTO(patient);
    }

    @Override
    public List<PatientLongDTO> findAll() {
        return patientRepository.findAll().stream().map(this::mapToDTO).collect(java.util.stream.Collectors.toList());
    }

    public List<PatientLongDTO> findByName(String name) {
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
    public PatientLongDTO mapToDTO(Patient patient) {
        return modelmapper.map(patient, PatientLongDTO.class);
    }

    public Patient mapToEntity(PatientLongDTO patientLongDTO) {
        return modelmapper.map(patientLongDTO, Patient.class);
    }


}
