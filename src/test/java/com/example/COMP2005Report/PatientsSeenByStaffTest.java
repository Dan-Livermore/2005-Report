package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.DependsOn;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PatientsSeenByStaffTest {

    @BeforeEach
    public void Startup() {
        PatientsSeenByStaff patientsseenbystaff = new PatientsSeenByStaff();
    }

    @Test
    public void DBConnectionPatientsTest() {
        JSONArray data = PatientsController.Patient.DBConnection();
        assertEquals(200, PatientsController.Patient.getStatus());
        assertNotEquals(0, PatientsController.Patient.getStatus());
    }


    @Test
    public void DBConnectionEmployeesTest() {
        JSONArray data = EmployeesController.Employee.DBConnection();
        assertEquals(200, EmployeesController.Employee.getStatus());
        assertNotEquals(0, EmployeesController.Employee.getStatus());
    }

    @Test
    public void DBConnectionAllocationsTest() {
        JSONArray data = AllocationsController.Allocation.DBConnection();
        assertEquals(200, AllocationsController.Allocation.getStatus());
        assertNotEquals(0, AllocationsController.Allocation.getStatus());
    }

    @Test
    public void DBConnectionAdmissionsTest() {
        JSONArray data = AdmissionsController.Admission.DBConnection();
        assertEquals(200, AdmissionsController.Admission.getStatus());
        assertNotEquals(0, AdmissionsController.Admission.getStatus());
    }

    @Test
    public void GetEmpIDEqualsTest() {
        //Arrange
        int actual = PatientsSeenByStaff.empID;

        //Assert
        assertEquals(4, actual);
        assertNotEquals(0, actual);

    }

    @Test
    public void GetEmpIDinRangeTest() {
        int actual = PatientsSeenByStaff.empID;
        assertTrue(actual > -1);
        assertFalse(actual > 300);
    }
}

