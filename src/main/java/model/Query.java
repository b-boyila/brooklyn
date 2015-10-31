package model;

import java.io.Serializable;

/**
 * Created by ktagintsev on 13.10.15.
 */
public class Query implements Serializable {

    private String name;
    private String phone;
    private String mail;

    public Query() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
