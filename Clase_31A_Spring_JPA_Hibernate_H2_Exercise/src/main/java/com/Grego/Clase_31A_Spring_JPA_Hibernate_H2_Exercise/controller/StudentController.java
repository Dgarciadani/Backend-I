package com.Grego.Clase_31A_Spring_JPA_Hibernate_H2_Exercise.controller;

import com.Grego.Clase_31A_Spring_JPA_Hibernate_H2_Exercise.model.Student;
import com.Grego.Clase_31A_Spring_JPA_Hibernate_H2_Exercise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController() {
    }

    @PostMapping("/create")
    public void saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }
    @GetMapping("/all")
    public Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/name={name}")
    public Student getStudentById(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

}
