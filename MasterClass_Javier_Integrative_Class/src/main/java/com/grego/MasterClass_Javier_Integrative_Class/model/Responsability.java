package com.grego.MasterClass_Javier_Integrative_Class.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Data
@Entity
@Table(name = "responsabilities")
public class Responsability {
    private Integer id;

    private String rol;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
}
