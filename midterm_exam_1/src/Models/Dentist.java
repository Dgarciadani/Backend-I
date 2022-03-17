package Models;

public class Dentist {
    private Long license_id;
    private String name;
    private String lastName;

    public Dentist(long license, String name, String lastName) {
        this.license_id = license;
        this.name = name;
        this.lastName = lastName;
    }

    public Long getLicense_id() {
        return license_id;
    }

    public void setLicense_id(Long license_id) {
        this.license_id = license_id;
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
}
