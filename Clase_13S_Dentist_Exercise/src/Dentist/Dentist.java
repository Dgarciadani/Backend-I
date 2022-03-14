package Dentist;

public class Dentist {
    private String name;
    private String lastName;
    private String registry;

    public Dentist(String name, String lastName, String registry) {
        this.name = name;
        this.lastName = lastName;
        this.registry = registry;
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

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registry='" + registry + '\'' +
                '}';
    }
}
