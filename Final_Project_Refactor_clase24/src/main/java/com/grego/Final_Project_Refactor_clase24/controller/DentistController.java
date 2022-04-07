package com.grego.Final_Project_Refactor_clase24.controller;


import com.grego.Final_Project_Refactor_clase24.domain.Dentist;
import com.grego.Final_Project_Refactor_clase24.services.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/dentist")
public class DentistController {


    @Autowired
    private IDentistService dentistService;



}






