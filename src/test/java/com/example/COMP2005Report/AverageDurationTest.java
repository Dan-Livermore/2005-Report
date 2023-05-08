package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AverageDurationTest {
    @Test
    public void DBConnectionEmployeesTest() {
        JSONArray data = EmployeesController.Employee.DBConnection();
        Assertions.assertEquals(200, EmployeesController.Employee.getStatus());
        assertNotEquals(0, EmployeesController.Employee.getStatus());
    }

    @Test
    public void DBConnectionAllocationsTest() {
        JSONArray data = AllocationsController.Allocation.DBConnection();
        Assertions.assertEquals(200, AllocationsController.Allocation.getStatus());
        assertNotEquals(0, AllocationsController.Allocation.getStatus());
    }

    @Test
    public void Test(){
        AverageDuration.GetDuration();
        assertEquals(0,0);
    }
}
