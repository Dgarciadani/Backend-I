package com.CTD;

public class Employee {

    private int  id;
    private int edad;
    private String name;
    private String lastName;
    private String fehcaInicio;

    public Employee(int id, int edad, String name, String lastName, String fehcaInicio) {
        this.id = id;
        this.edad = edad;
        this.name = name;
        this.lastName = lastName;
        this.fehcaInicio = fehcaInicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

    public String getFehcaInicio() {
        return fehcaInicio;
    }

    public void setFehcaInicio(String fehcaInicio) {
        this.fehcaInicio = fehcaInicio;
    }
}
