package com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain;

import java.util.Date;

public class Appointment {
    private Integer appointment_id;
    private Dentist dentist;
    private Patient patient;
    private Date date;

    public Appointment(Integer appointment_id, Dentist dentist, Patient patient, Date date) {
        this.appointment_id = appointment_id;
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
    }

    public Appointment(Dentist dentist, Patient patient, Date date) {
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
    }

    public Integer getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(Integer appointment_id) {
        this.appointment_id = appointment_id;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointment_id=" + appointment_id +
                ", dentist=" + dentist +
                ", patient=" + patient +
                ", date=" + date +
                '}';
    }
}
