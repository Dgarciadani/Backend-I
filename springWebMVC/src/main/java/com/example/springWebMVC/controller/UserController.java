package com.example.springWebMVC.controller;

import com.example.springWebMVC.domain.User;
import com.example.springWebMVC.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService = new UserService();

    @GetMapping("/")
    public User createUser(){
        return userService.createUser("Marcos",23);
    }

    @GetMapping("/maps")
    public User createUser2(){
        return userService.createUser("Pablo",45);
    }
}
 