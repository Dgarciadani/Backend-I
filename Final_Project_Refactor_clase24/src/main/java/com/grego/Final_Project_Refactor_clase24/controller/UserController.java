package com.grego.Final_Project_Refactor_clase24.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

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
