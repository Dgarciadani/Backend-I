package com.grego.MasterClass_Javier_Integrative_Class.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
@Data
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate initialDate;
    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private Set<Responsability> responsabilities;
}
