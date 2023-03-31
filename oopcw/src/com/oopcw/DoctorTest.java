package com.oopcw;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {
    Doctor d1= new Doctor("safa","saifudeen","2001,10,10","0774196629","123","cosmetic");

    @Test
    void setMedicalLicenseNumber() {
        assertEquals("123",d1.getMedicalLicenseNumber());
    }

    @Test
    void setSpecialisation() {
        assertEquals("cosmetic",d1.getSpecialisation());
    }
}