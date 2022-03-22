package com.example.springIntro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;



@SpringBootApplication
@RestController

public class SpringIntroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntroApplication.class, args);
    }

    @GetMapping
    public String holaMundo() {
        Instant now = Instant.now();
        return "<a href='https://www.facebook.com'> holaMundo <a/>" + "<h1>"+now;
    }
}
