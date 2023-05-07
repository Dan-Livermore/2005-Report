package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PatientsDischarged3DaysTest {

    @Test
    public void DBConnectionPatientsTest() {
        JSONArray data = PatientsController.Patient.DBConnection();
        assertEquals(200, PatientsController.Patient.getStatus());
        assertNotEquals(0, PatientsController.Patient.getStatus());
    }

    @Test
    public void DBConnectionAdmissionsTest() {
        JSONArray data = AdmissionsController.Admission.DBConnection();
        assertEquals(200, AdmissionsController.Admission.getStatus());
        assertNotEquals(0, AdmissionsController.Admission.getStatus());
    }

    @Test
    public void ThreeDays() {
        JSONArray data = PatientsDischarged3Days.GetData();
        assertEquals(200, 200);
    }
}
