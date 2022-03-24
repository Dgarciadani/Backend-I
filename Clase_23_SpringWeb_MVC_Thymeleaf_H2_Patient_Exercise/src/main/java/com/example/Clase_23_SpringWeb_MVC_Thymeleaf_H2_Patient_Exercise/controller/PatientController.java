package com.example.Clase_23_SpringWeb_MVC_Thymeleaf_H2_Patient_Exercise.controller;

import com.example.Clase_23_SpringWeb_MVC_Thymeleaf_H2_Patient_Exercise.domain.Patient;
import com.example.Clase_23_SpringWeb_MVC_Thymeleaf_H2_Patient_Exercise.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class PatientController {

    @GetMapping("/index")
    public String usuario1(Model model) {
        PatientService patientService = new PatientService();
        Patient patient1 = PatientService.createPatient(2, "Pedro", "lopez", "pepi@gmail.com", 465546, 2, "siempreviva", 743, "Springfield", "oregon");
        model.addAttribute("name", patient1.getName());
        model.addAttribute("lastname",patient1.getLastName());
        System.out.println(PatientService.searchPatient("pepi@gmail.com").getName());
        return "index";
    }


}
