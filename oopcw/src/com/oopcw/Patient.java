package com.oopcw;

import java.util.Date;

public class Patient extends Person {
    String id;

    public Patient(String name, String surname, String dateofbirth, String mobileNumber, String id) {
        super(name, surname, dateofbirth, mobileNumber);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Patient{" +super.toString()+
                "id=" + id +
                '}';
    }
}
