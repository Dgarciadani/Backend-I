package com.example.Clase_25A_SpringBoot_API_Exercise.controller;

import com.example.Clase_25A_SpringBoot_API_Exercise.dao.DaoMedicineH2;
import com.example.Clase_25A_SpringBoot_API_Exercise.domain.Medicine;
import com.example.Clase_25A_SpringBoot_API_Exercise.services.MedicineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
    private MedicineService medicineService = new MedicineService(new DaoMedicineH2());


    @PostMapping("/register")
    public Medicine save(@RequestBody Medicine medicine) {

        return medicineService.register(medicine);
    }

    @GetMapping("/id={id}")
    public Medicine searchById(@PathVariable int id) {

        return medicineService.search(id);
    }


}

