package com.grego.MasterClass_Javier_Integrative_Class.controller;

import com.grego.MasterClass_Javier_Integrative_Class.model.dtos.PersonDTO;
import com.grego.MasterClass_Javier_Integrative_Class.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/person")

public class PersonController {
    @Autowired
    private PersonService personService;


    @GetMapping("/id={id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Integer id){
        return ResponseEntity.ok(personService.findPersonById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<PersonDTO> addPerson(@RequestBody PersonDTO personDTO){
        return ResponseEntity.ok(personService.savePerson(personDTO));
    }
    @PutMapping("/id={id}")
    public void updatePerson(@PathVariable Integer id, @RequestBody PersonDTO personDTO){
        personService.updatePerson(id, personDTO);
    }
    @DeleteMapping("/id={id}")
    public void deletePerson(@PathVariable Integer id){
        personService.deletePerson(id);
    }
    @GetMapping("/all")
    public ResponseEntity<Set<PersonDTO>> getAllPersons(){
        return ResponseEntity.ok(personService.findAll());
    }

}
