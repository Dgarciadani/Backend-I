package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.controller;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Appointment;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.impl.AppointmentDaoH2;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    AppointmentService appointmentService = new AppointmentService(new AppointmentDaoH2());

    @GetMapping("/id={id}")
    public ResponseEntity<Appointment> search(@PathVariable int id){
        ResponseEntity responseEntity = null;
        if (appointmentService.search(id) == null) {
            responseEntity = ResponseEntity.notFound().build();

        }else{
            responseEntity = ResponseEntity.ok(appointmentService.search(id));
        }
        return responseEntity;
    }
    @PostMapping("/register")
    public ResponseEntity<Appointment> register(@RequestBody Appointment appointment){
        ResponseEntity responseEntity = null;

            responseEntity = ResponseEntity.ok(appointmentService.register(appointment));
        return responseEntity;
    }
    @DeleteMapping("/id={id}")
    public ResponseEntity<Appointment> delete(@PathVariable int id){
        ResponseEntity responseEntity = null;
        if (appointmentService.search(id) == null) {
            responseEntity = ResponseEntity.notFound().build();

        }else{
            appointmentService.delete(id);
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @PutMapping
    public ResponseEntity<Appointment> update(@PathVariable int id,@RequestBody Appointment appointment){
        ResponseEntity responseEntity = null;
        if (appointmentService.search(id) == null) {
            responseEntity = ResponseEntity.notFound().build();

        }else{
            responseEntity = ResponseEntity.ok(appointmentService.update(id,appointment));
        }
        return responseEntity;
    }

}