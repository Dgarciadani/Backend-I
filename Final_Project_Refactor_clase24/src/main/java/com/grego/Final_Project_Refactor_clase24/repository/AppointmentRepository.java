package com.grego.Final_Project_Refactor_clase24.repository;

import com.grego.Final_Project_Refactor_clase24.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

   /* @Query("SELECT a FROM Appointment a WHERE a.patient_id = ?1")
    public List<Appointment> findByPatientId(Integer patientId);

    @Query("SELECT a FROM Appointment a WHERE a.dentist_id = ?1")
    public List<Appointment> findByDentistId(Integer dentistId);*/
}
