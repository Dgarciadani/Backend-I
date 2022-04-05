package com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.controller;

import com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Patient;
import com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")

public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        ResponseEntity responseEntity = null;
        responseEntity = new ResponseEntity(patientService.register(patient), HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("/id={id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Integer id) {
        ResponseEntity responseEntity = null;
        if (patientService.search(id) == null) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            responseEntity = new ResponseEntity(patientService.search(id), HttpStatus.OK);
        }
        return responseEntity;
    }

    @DeleteMapping("/id={id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable int id) {
        ResponseEntity responseEntity = null;
        if (patientService.search(id) == null) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);

        } else responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);
        return responseEntity;
    }

    @PutMapping("/id={id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable int id, @RequestBody Patient patient) {
        ResponseEntity responseEntity = null;
        if (patientService.search(id) == null) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);

        } else responseEntity = new ResponseEntity(patientService.update(id, patient), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/all")
    public ResponseEntity<Patient> getAllPatients() {
        ResponseEntity responseEntity = null;
        if (patientService.searchAll() == null) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);

        } else responseEntity = new ResponseEntity(patientService.searchAll(), HttpStatus.OK);
        return responseEntity;
    }

}

