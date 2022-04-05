package com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services;

import com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Dentist;
import com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.Idao;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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

    public Dentist register(Dentist dentist) {
        return dentistIdao.register(dentist);
    }

    public Dentist search(Integer id) {
        return dentistIdao.search(id);
    }

    public Dentist update(Integer id, Dentist dentist) {
        return dentistIdao.update(id, dentist);
    }

    public void delete(Integer id) {
        dentistIdao.delete(id);
    }

    public List<Dentist> searchAll() {
        return dentistIdao.searchAll();
    }

}
