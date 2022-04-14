package com.grego.MasterClass_Javier_Integrative_Class.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;

    @OneToMany(mappedBy = "person")
    @JsonIgnore
    private Set<Responsability> responsabilities;
}

