package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.DependsOn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PatientsSeenByStaffTest {

    @Test
    public void DBConnectionPatientsTest(){
        JSONArray data = EmployeesController.Employee.DBConnection();
        assertEquals(200, PatientsController.Patient.DBConnection());
        assertNotEquals(300, PatientsController.Patient.DBConnection());
    }


    @Test
    public void DBConnectionEmployeesTest(){
        JSONArray data = EmployeesController.Employee.DBConnection();
        assertEquals(200, EmployeesController.Employee.getStatus());
        assertNotEquals(0, EmployeesController.Employee.getStatus());
    }

    @Test
    public void DBConnectionAllocationsTest(){
        JSONArray data = EmployeesController.Employee.DBConnection();
        assertEquals(200, AllocationsController.Allocation.getStatus());
        assertNotEquals(300, AllocationsController.Allocation.getStatus());
    }
    @Test
    public void DBConnectionAdmissionsTest(){
        JSONArray data = EmployeesController.Employee.DBConnection();
        assertEquals(200, AdmissionsController.Admission.DBConnection());
        assertNotEquals(300, AdmissionsController.Admission.DBConnection());
    }

    @Test
    public void GetDataTest(){
        assertEquals(3,PatientsSeenByStaff.GetData());
    }
}
