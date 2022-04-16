package com.grego.Final_Project_Refactor_clase24.controller;


import com.grego.Final_Project_Refactor_clase24.dto.AppointmentDTO;
import com.grego.Final_Project_Refactor_clase24.services.impl.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/id={id}")
    public ResponseEntity<AppointmentDTO> findAppointmentById(@PathVariable Integer id) {
        return ResponseEntity.ok(appointmentService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<AppointmentDTO> addAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appointmentService.save(appointmentDTO));
    }

    @PutMapping("/id={id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable Integer id, @RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appointmentService.update(id, appointmentDTO));
    }

    @DeleteMapping("/id={id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Integer id) {
        appointmentService.deleteById(id);
        return ResponseEntity.ok().body("Appointment deleted");
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<AppointmentDTO>> findAllAppointments() {
        return ResponseEntity.ok(appointmentService.findAll());
    }

    @GetMapping("/dentist={id}")
    public ResponseEntity<Iterable<AppointmentDTO>> findAllAppointmentsByDentistId(@PathVariable Integer id) {
        return ResponseEntity.ok(appointmentService.findByDentistId(id));
    }

    @GetMapping("/patient={id}")
    public ResponseEntity<Iterable<AppointmentDTO>> findAllAppointmentsByPatientId(@PathVariable Integer id) {
        return ResponseEntity.ok(appointmentService.findByPatientId(id));
    }

    @DeleteMapping("/dentist={id}")
    public ResponseEntity<String> deleteAppointmentByDentistId(@PathVariable Integer id) {
        appointmentService.deleteByDentistId(id);
        return ResponseEntity.ok().body("Appointments deleted");
    }
@DeleteMapping("/patient={id}")
    public ResponseEntity<String> deleteAppointmentByPatientId(@PathVariable Integer id) {
        appointmentService.deleteByPatientId(id);
        return ResponseEntity.ok().body("Appointments deleted");
    }

}

