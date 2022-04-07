package com.Grego.Clase_31A_Spring_JPA_Hibernate_H2_Exercise.service;

import com.Grego.Clase_31A_Spring_JPA_Hibernate_H2_Exercise.model.School;
import com.Grego.Clase_31A_Spring_JPA_Hibernate_H2_Exercise.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    private SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School findByAddress(String address) {
        return schoolRepository.findByAddress(address).get();
    }

}
