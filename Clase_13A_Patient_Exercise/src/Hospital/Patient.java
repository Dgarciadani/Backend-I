package Hospital;

public class Patient {
    private String name;
    private String lastName;
    private String address;
    private int dni;
    private String startDate;
    private String user;
    private String pass;

    public Patient(String name, String lastName, String address, int dni, String startDate, String user, String pass) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.dni = dni;
        this.startDate = startDate;
        this.user = user;
        this.pass = pass;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", dni=" + dni +
                ", startDate='" + startDate + '\'' +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
