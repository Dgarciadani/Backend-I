package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.controller;

import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain.Dentist;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.repository.impl.DentistDaoH2;
import com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.services.DentistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    DentistService dentistService = new DentistService(new DentistDaoH2());
    @GetMapping("/id={id}")
    public ResponseEntity<Dentist> search(@RequestParam("id")int id){
        ResponseEntity responseEntity = null;

        if (dentistService.search(id) == null) {
            responseEntity = ResponseEntity.notFound().build();

        }else {
            responseEntity = ResponseEntity.ok(dentistService.search(id));
        }
        return responseEntity;
    }
    @PostMapping("/register")
    public ResponseEntity<Dentist> register(@RequestBody Dentist dentist){
        ResponseEntity responseEntity = null;

        if (dentistService.register(dentist) == null) {
            responseEntity = ResponseEntity.notFound().build();

        }else {
            responseEntity = ResponseEntity.ok(dentistService.register(dentist));
        }
        return responseEntity;
    }
    @PutMapping("/id={id}")
    public ResponseEntity<Dentist> update(@PathVariable int id,@RequestBody Dentist dentist){
        ResponseEntity responseEntity = null;

        if (dentistService.search(id) == null) {
            responseEntity = ResponseEntity.notFound().build();

        }else {
            responseEntity = ResponseEntity.ok(dentistService.update(id,dentist));
        }
        return responseEntity;
    }
    @DeleteMapping("/id={id}")
    public ResponseEntity<Dentist> delete(@PathVariable int id){
        ResponseEntity responseEntity = null;

        if (dentistService.search(id) == null) {
            responseEntity = ResponseEntity.notFound().build();

        }else {
            dentistService.delete(id);
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}


