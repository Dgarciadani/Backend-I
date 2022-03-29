package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Dentist;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.Idao;

import java.util.List;

public class DentistService implements Idao<Dentist> {
    private Idao<Dentist> dentistIdao;

    public DentistService(Idao<Dentist> dentistIdao) {
        this.dentistIdao = dentistIdao;
    }

    public Idao<Dentist> getDentistIdao() {
        return dentistIdao;
    }

    public void setDentistIdao(Idao<Dentist> dentistIdao) {
        this.dentistIdao = dentistIdao;
    }
    public Dentist register(Dentist dentist){
        return dentistIdao.register(dentist);
    }
    public Dentist search(int id){
        return dentistIdao.search(id);
    }
    public Dentist update(int id, Dentist dentist){
        return dentistIdao.update(id, dentist);
    }
    public void delete(int id){
        dentistIdao.delete(id);
    }
    public List<Dentist> searchAll(){
        return dentistIdao.searchAll();
    }

}
