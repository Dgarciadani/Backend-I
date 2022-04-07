package com.grego.Final_Project_Refactor_clase24.repository;

import com.grego.Final_Project_Refactor_clase24.domain.Patient;
import com.grego.Final_Project_Refactor_clase24.dto.PatientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {


    @Query("select p from Patient p where p.name like %?1%")
    List<Patient> findByName(String name);
}
