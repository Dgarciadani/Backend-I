package com.grego.Final_Project_Refactor_clase24.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name= "dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dentist_id;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private Integer register;

    private Set<Appointment> appointments;

    public Dentist() {
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "dentist_id=" + dentist_id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", register=" + register +
                ", appointments=" + appointments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dentist dentist = (Dentist) o;
        return Objects.equals(dentist_id, dentist.dentist_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dentist_id);
    }
}
