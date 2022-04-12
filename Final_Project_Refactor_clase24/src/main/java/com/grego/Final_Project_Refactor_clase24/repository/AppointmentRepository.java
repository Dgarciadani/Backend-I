package com.grego.Final_Project_Refactor_clase24.repository;

import com.grego.Final_Project_Refactor_clase24.domain.Appointment;
import com.grego.Final_Project_Refactor_clase24.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query("select a from Appointment a where a.patient.id = ?1")
    List<Appointment> findByPatientId(int id);

    @Query("select a from Appointment a where a.dentist.id = ?1")
    List<Appointment> findByDentistId(int id);

  /*  @Query("SELECT a FROM Appointment a WHERE a.dentist_id = ?1")
     List<Appointment> findByDentistId(Integer dentistId);*/

/*    @Query("select p from Patient p where p.name like %?1%")
    List<Patient> findByName(String name);
}*/
}