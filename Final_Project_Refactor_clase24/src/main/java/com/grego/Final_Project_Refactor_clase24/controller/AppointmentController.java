package com.grego.Final_Project_Refactor_clase24.controller;


import com.grego.Final_Project_Refactor_clase24.dto.AppointmentDTO;
import com.grego.Final_Project_Refactor_clase24.services.impl.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
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
    public ResponseEntity<AppointmentDTO> deleteAppointment(@PathVariable Integer id) {
        appointmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/all")
    public ResponseEntity<Iterable<AppointmentDTO>> findAllAppointments() {
        return ResponseEntity.ok(appointmentService.findAll());
    }
}

