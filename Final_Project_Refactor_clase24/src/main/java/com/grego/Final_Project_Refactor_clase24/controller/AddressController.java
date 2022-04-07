package com.grego.Final_Project_Refactor_clase24.controller;

import com.grego.Final_Project_Refactor_clase24.dto.AddressDTO;
import com.grego.Final_Project_Refactor_clase24.services.impl.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/id={id}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable Integer id){
        return ResponseEntity.ok(addressService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<AddressDTO> addAddress(@RequestBody AddressDTO addressDTO){
        return ResponseEntity.ok(addressService.save(addressDTO));
    }

    @PutMapping("/id={id}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable Integer id, @RequestBody AddressDTO addressDTO){
        return ResponseEntity.ok(addressService.update(id, addressDTO));
    }

    @DeleteMapping("/id={id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Integer id){
        addressService.deleteById(id);
        return ResponseEntity.ok("Address deleted");
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<AddressDTO>> getAllAddress(){
        return ResponseEntity.ok(addressService.findAll());
    }
}




