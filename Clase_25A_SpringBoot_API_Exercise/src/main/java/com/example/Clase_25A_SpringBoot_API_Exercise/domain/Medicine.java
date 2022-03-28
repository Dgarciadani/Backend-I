package com.example.Clase_25A_SpringBoot_API_Exercise.domain;

public class Medicine {
    private int id;
    private String name;
    private String brand;
    private int registryFDA;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegistryFDA() {
        return registryFDA;
    }

    public void setRegistryFDA(int registryFDA) {
        this.registryFDA = registryFDA;
    }


}
