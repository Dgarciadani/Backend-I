package com.grego.MasterClass_Javier_Integrative_Class.repository;

import com.grego.MasterClass_Javier_Integrative_Class.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {
}
