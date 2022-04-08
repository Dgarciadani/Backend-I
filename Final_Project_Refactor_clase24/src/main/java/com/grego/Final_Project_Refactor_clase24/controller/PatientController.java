package com.grego.Final_Project_Refactor_clase24.controller;


import com.grego.Final_Project_Refactor_clase24.dto.PatientLongDTO;
import com.grego.Final_Project_Refactor_clase24.services.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")

public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/id={id}")
    public ResponseEntity<PatientLongDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(patientService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<PatientLongDTO> savePatient(@RequestBody PatientLongDTO patientLongDTO) {
        return ResponseEntity.ok(patientService.save(patientLongDTO));
    }

    @PutMapping("/id={id}")
    public ResponseEntity<PatientLongDTO> updatePatient(@PathVariable Integer id, @RequestBody PatientLongDTO patientLongDTO) {
        return ResponseEntity.ok(patientService.update(id, patientLongDTO));
    }

    @DeleteMapping("/id={id}")
    public ResponseEntity<String> deletePatient(@PathVariable Integer id) {
        patientService.deleteById(id);
        return ResponseEntity.ok().body("Patient deleted");
        //HABRIA QUE REFACTORIZAR PARA OPTENER UNA RESPUESTA DE DELETE
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<PatientLongDTO>> findAll() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping("/name={name}")
    public ResponseEntity<Iterable<PatientLongDTO>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(patientService.findByName(name));
    }
}

