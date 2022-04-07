package com.grego.Final_Project_Refactor_clase24.domain;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter

@Entity
@Table(name = "patients")

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patient_id;
    @NotNull
    private String name;
    @NotNull
    private String lastName;


    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;


    @NotNull
    private Integer dni;
    @NotNull
    private Date dateInit;


    private Set<Appointment> appointments;

    public Patient() {
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + patient_id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", dni=" + dni +
                ", dateInit=" + dateInit +
                ", appointments=" + appointments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(patient_id, patient.patient_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient_id);
    }
}
