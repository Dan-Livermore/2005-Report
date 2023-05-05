package com.example.COMP2005Report;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PatientsSeenByStaffTest {

    @Test
    public void TestDBConnectionTest(){
        assertEquals(200, PatientsSeenByStaff.GetPatientsController.Patient.DBConnection());
        assertNotEquals(300, PatientsSeenByStaff.GetPatientsController.Patient.DBConnection());
    }
}
