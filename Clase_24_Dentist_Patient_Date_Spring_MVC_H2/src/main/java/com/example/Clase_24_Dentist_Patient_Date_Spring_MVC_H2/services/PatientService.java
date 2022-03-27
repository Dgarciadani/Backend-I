package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Patient;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.idao.Idao;

import java.util.List;

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
     public Patient search(int id){
        return patientIdao.search(id);
     }
     public Patient update(int id, Patient patient){
        return patientIdao.update(id, patient);
     }
     public void delete(int id){
        patientIdao.delete(id);
     }
     public List<Patient> searchAll(){
        return patientIdao.searchAll();




     }

}
