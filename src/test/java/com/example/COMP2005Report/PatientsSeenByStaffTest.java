package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PatientsSeenByStaffTest {

    @Test
    public void DBConnectionPatientsTest(){
        assertEquals(200, PatientsController.Patient.DBConnection());
        assertNotEquals(300, PatientsController.Patient.DBConnection());
    }

    @Test
    public void DBConnectionEmployeesTest(){
        assertEquals(200, EmployeesController.Employee.DBConnection());
        assertNotEquals(300, EmployeesController.Employee.DBConnection());
    }

    @Test
    public void DBConnectionAllocationsTest(){
        assertEquals(200, AllocationsController.Allocation.DBConnection());
        assertNotEquals(300, AllocationsController.Allocation.DBConnection());
    }
    @Test
    public void DBConnectionAdmissionsTest(){
        assertEquals(200, AdmissionsController.Admission.DBConnection());
        assertNotEquals(300, AdmissionsController.Admission.DBConnection());
    }

    @Test
    public void GetDataTest(){
        assertEquals(3,PatientsSeenByStaff.GetData());
    }
}
