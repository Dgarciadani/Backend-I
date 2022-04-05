package com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services;

import com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Patient;
import com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.Idao;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientService {
    private Idao<Patient> patientIdao;


    public PatientService(Idao<Patient> patientIdao) {
        this.patientIdao = patientIdao;
    }

    public Idao<Patient> getPatientIdao() {
        return patientIdao;
    }

    public void setPatientIdao(Idao<Patient> patientIdao) {
        this.patientIdao = patientIdao;
    }
     public Patient register(Patient patient){
        return patientIdao.register(patient);
     }
     public Patient search(Integer id){
        return patientIdao.search(id);
     }
     public Patient update(Integer id, Patient patient){
        return patientIdao.update(id, patient);
     }
     public void delete(Integer id){
        patientIdao.delete(id);
     }
     public List<Patient> searchAll(){
        return patientIdao.searchAll();




     }

}
