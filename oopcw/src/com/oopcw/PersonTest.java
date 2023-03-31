package com.oopcw;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {


    Person p1= new Person("safa","Saifudeen","12-01-2001","0774196629");

    @Test
    void setName() {
        assertEquals("safa",p1.getName());
    }

    @Test
    void setSurname() {
        assertEquals("Saifudeen",p1.getSurname());
    }

    @Test
    void setDateofbirth() {
        assertEquals("12-01-2001",p1.getDateofbirth());

    }

    @Test
    void setMobileNumber() {
        assertEquals("0774196629",p1.getMobileNumber());
    }
}