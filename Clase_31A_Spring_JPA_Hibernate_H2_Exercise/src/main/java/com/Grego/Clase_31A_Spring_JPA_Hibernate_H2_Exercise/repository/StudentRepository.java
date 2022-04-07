package com.Grego.Clase_31A_Spring_JPA_Hibernate_H2_Exercise.repository;

import com.Grego.Clase_31A_Spring_JPA_Hibernate_H2_Exercise.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select s from Student s where s.name = ?1")
    Optional<Student> findByName(String name);

}
