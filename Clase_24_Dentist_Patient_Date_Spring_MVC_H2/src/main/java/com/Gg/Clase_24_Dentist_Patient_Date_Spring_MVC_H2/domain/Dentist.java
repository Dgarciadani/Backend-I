package com.Gg.Clase_24_Dentist_Patient_Date_Spring_MVC_H2.domain;

public class Dentist {
    private Integer dentist_id;
    private String name;
    private String lastName;
    private Integer register;

    public Dentist(Integer id, String name, String lastName, Integer register) {
        this.dentist_id = id;
        this.name = name;
        this.lastName = lastName;
        this.register = register;
    }

    public Dentist(String name, String lastName, Integer register) {
        this.name = name;
        this.lastName = lastName;
        this.register = register;
    }

    public Integer getDentist_id() {
        return dentist_id;
    }

    public void setDentist_id(Integer dentist_id) {
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

    public Integer getRegister() {
        return register;
    }

    public void setRegister(Integer register) {
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
