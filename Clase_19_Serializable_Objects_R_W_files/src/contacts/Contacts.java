package contacts;

import java.io.Serializable;

public class Contacts implements Serializable {
    private String name;
    private String mail;
    private Long phonenumber;

    public Contacts(String name, String mail, Long phonenumber) {
        this.name = name;
        this.mail = mail;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }
}
