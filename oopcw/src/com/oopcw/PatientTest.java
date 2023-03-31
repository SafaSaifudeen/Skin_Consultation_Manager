package com.oopcw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    Patient patient= new Patient("safa","saifudeen", "10-10-2001","0774196629","011");

    @Test
    void setId() {
        assertEquals("011","011");
    }
}