package com.grego.Final_Project_Refactor_clase24.controller;

import com.grego.Final_Project_Refactor_clase24.login.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


//    @GetMapping("/login")
//    public String index() {
//        return "Hello World";
//    }

    @GetMapping("/")
    public String home() {
        return "<h1>Welcome</h1>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h1>Welcome user</h1>";
    }
    @GetMapping("/admin")
    public String admin() {
        return "<h1>Welcome admin</h1>";
    }



}
