package com.example.Clase_25A_SpringBoot_API_Exercise.controller;

import com.example.Clase_25A_SpringBoot_API_Exercise.dao.DaoMedicineH2;
import com.example.Clase_25A_SpringBoot_API_Exercise.domain.Medicine;
import com.example.Clase_25A_SpringBoot_API_Exercise.services.MedicineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
    private MedicineService medicineService = new MedicineService(new DaoMedicineH2());


    @PostMapping("/register")
    public ResponseEntity<Medicine> save(@RequestBody Medicine medicine) {
        ResponseEntity responseEntity = null;

        responseEntity = new ResponseEntity(medicineService.register(medicine), HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("/id={id}")
    public ResponseEntity<Medicine> searchById(@PathVariable int id) {
        ResponseEntity responseEntity = null;
        if (medicineService.search(id) == null) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            responseEntity = new ResponseEntity(medicineService.search(id), HttpStatus.OK);
        }

        return responseEntity;
    }

    @DeleteMapping("/id={id}")
    public ResponseEntity deleteMedicine(@PathVariable int id) {
        ResponseEntity responseEntity = null;
        if (medicineService.search(id) == null) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            medicineService.delete(id);
            responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @PutMapping("/id={id}")
    public ResponseEntity<Medicine> update(@PathVariable int id, @RequestBody Medicine medicine) {
        ResponseEntity responseEntity = null;

        if (medicineService.search(id) == null) {
             responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
             responseEntity = new ResponseEntity(medicineService.update(id, medicine), HttpStatus.OK);
        }
        return responseEntity;

    }
}

