package com.example.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain;

public class Dentist {
    private int dentist_id;
    private String name;
    private String lastName;
    private int register;

    public Dentist(int id, String name, String lastName, int register) {
        this.dentist_id = id;
        this.name = name;
        this.lastName = lastName;
        this.register = register;
    }

    public Dentist(String name, String lastName, int register) {
        this.name = name;
        this.lastName = lastName;
        this.register = register;
    }

    public int getDentist_id() {
        return dentist_id;
    }

    public void setDentist_id(int dentist_id) {
        this.dentist_id = dentist_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRegister() {
        return register;
    }

    public void setRegister(int register) {
        this.register = register;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + dentist_id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", register=" + register +
                '}';
    }
}
