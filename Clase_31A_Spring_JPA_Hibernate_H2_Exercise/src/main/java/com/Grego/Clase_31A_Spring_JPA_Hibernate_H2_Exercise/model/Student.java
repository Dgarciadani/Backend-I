package com.Grego.Clase_31A_Spring_JPA_Hibernate_H2_Exercise.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
@SequenceGenerator(name="student_seq", sequenceName="student_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="student_seq")
    private Integer id;
    private String name;
    private Integer age;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id")
    private School school;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
