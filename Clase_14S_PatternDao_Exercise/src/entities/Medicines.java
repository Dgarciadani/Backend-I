package entities;

public class Medicines {
    private String name;
    private String brand;
    private Long id;
    private Long registryFDA;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegistryFDA() {
        return registryFDA;
    }

    public void setRegistryFDA(Long registryFDA) {
        this.registryFDA = registryFDA;
    }
}
