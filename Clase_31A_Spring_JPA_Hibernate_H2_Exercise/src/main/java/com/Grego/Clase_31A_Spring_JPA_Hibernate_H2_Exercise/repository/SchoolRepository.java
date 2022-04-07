package com.Grego.Clase_31A_Spring_JPA_Hibernate_H2_Exercise.repository;

import com.Grego.Clase_31A_Spring_JPA_Hibernate_H2_Exercise.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Integer> {

    @Query("Select s from School s where s.address = ?1")
    Optional<School> findByAddress(String address);

}
