package com.example.springWebMVC.service;

import com.example.springWebMVC.domain.User;

public class UserService {

    public User createUser(String name,int age){
        User user = new User(name,age);
        return user;

    }
}
