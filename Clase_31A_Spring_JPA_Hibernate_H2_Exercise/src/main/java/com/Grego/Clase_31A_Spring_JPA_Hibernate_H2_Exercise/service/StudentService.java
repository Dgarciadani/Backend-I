package com.Grego.Clase_31A_Spring_JPA_Hibernate_H2_Exercise.service;


import com.Grego.Clase_31A_Spring_JPA_Hibernate_H2_Exercise.model.Student;
import com.Grego.Clase_31A_Spring_JPA_Hibernate_H2_Exercise.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentByName(String name) {
        return studentRepository.findByName(name).get();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

}
