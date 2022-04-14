package com.grego.MasterClass_Javier_Integrative_Class.repository;

import com.grego.MasterClass_Javier_Integrative_Class.model.Responsability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResponsabilityRepository extends JpaRepository<Responsability, Integer> {
}
