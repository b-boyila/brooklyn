package help;

import java.io.Serializable;

/**
 * Created by ktagintsev on 09.11.15.
 */
public class Search {

    private String name;

    private String email;

    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEmpty(){
        // @formatter:off
        return null == name &&
               null == email &&
               null == phone ||
               name.trim().isEmpty() &&
               email.trim().isEmpty() &&
               phone.trim().isEmpty();
        // @formatter:on
    }

    @Override
    public String toString() {
        return name + email + phone;
    }
}
