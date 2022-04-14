package com.grego.MasterClass_Javier_Integrative_Class.controller;

import com.grego.MasterClass_Javier_Integrative_Class.model.Responsability;
import com.grego.MasterClass_Javier_Integrative_Class.model.dtos.ResponsabilityDTO;
import com.grego.MasterClass_Javier_Integrative_Class.service.ResponsabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/responsability")
public class ResponsabilityController {

    @Autowired
    private ResponsabilityService responsabilityService;

    @GetMapping("/id={id}")
    public ResponseEntity<ResponsabilityDTO> getResponsabilityById(@PathVariable Integer id){
        return ResponseEntity.ok(responsabilityService.findResponsabilityById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<ResponsabilityDTO> addResponsability(@RequestBody ResponsabilityDTO responsability){
        return ResponseEntity.ok(responsabilityService.saveResponsability(responsability));
    }
    @PutMapping("/id={id}")
    public void updateResponsability(@PathVariable Integer id,@RequestBody ResponsabilityDTO responsability){
         responsabilityService.updateResponsability(id, responsability);
    }
    @DeleteMapping("/id={id}")
    public void deleteResponsability(@PathVariable Integer id){
        responsabilityService.deleteResponsability(id);
    }
    @GetMapping("/all")
    public ResponseEntity<Iterable<ResponsabilityDTO>> getAllResponsabilities(){
        return ResponseEntity.ok(responsabilityService.findAll());
    }
}
