package com.example.COMP2005Report;


import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MostAdmissionDayTest {

    @Test
    public void DBConnectionAdmissionsTest() {
        JSONArray data = AdmissionsController.Admission.DBConnection();
        assertEquals(200, AdmissionsController.Admission.getStatus());
        assertNotEquals(0, AdmissionsController.Admission.getStatus());
    }

    @Test
    public void indexTest(){
        MostAdmissionDay.GetData();
        assertEquals(0,0);
    }
}
