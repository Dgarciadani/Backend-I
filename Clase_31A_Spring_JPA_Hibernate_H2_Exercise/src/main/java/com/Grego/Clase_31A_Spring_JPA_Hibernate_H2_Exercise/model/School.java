package com.Grego.Clase_31A_Spring_JPA_Hibernate_H2_Exercise.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="schools")

public class School {

    @Id
    @SequenceGenerator(name = "school_seq", sequenceName = "school_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_seq")
    private Integer id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "school",fetch = FetchType.LAZY)
    private Set<Student> students = new HashSet<>();

    public School() {
    }

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
