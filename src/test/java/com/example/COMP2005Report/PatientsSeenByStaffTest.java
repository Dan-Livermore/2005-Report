package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class PatientsSeenByStaffTest {

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
        PatientsSeenByStaff x = new PatientsSeenByStaff();
        PatientsSeenByStaff.GetData();
        assertEquals(200, AdmissionsController.Admission.getStatus());
        assertNotEquals(0, AdmissionsController.Admission.getStatus());
    }




    @Test
    public void UsesAPIDataTest(){
        PatientsSeenByStaff x = new PatientsSeenByStaff();
        JSONArray expected = new JSONArray();
        JSONArray output = PatientsSeenByStaff.main();
        assertEquals("Heather", output.getJSONObject(0).get("forename"));
        assertEquals("Carter",output.getJSONObject(0).get("surname"));
        assertEquals("2224446666",output.getJSONObject(0).get("nhsNumber"));
        assertEquals(2,output.getJSONObject(0).get("id"));

    }

    @Test
    public void Only2PatientsTest(){
        PatientsSeenByStaff x = new PatientsSeenByStaff();
        PatientsController pat = new PatientsController();

        String patient = "[{\"forename\":\"Heather\",\"surname\":\"Carter\",\"id\":2,\"nhsNumber\":\"2224446666\"}]";
        PatientsController.Patient.JsonParse(patient);

        EmployeesController emp = new EmployeesController();
        String employee = "[{\"id\": 4,\"surname\": \"Jones\",\"forename\": \"Sarah\"}]";
        EmployeesController.Employee.JsonParse(employee);

        AdmissionsController adm = new AdmissionsController();
        String admission = "[{\"id\": 2,\"admissionDate\": \"2020-12-07T22:14:00\",\"dischargeDate\": \"0001-01-01T00:00:00\",\"patientID\": 1}]";
        AdmissionsController.Admission.JsonParse(admission);

        AllocationsController all = new AllocationsController();
        String allocation = "[{\"id\": 1,\"admissionID\": 1, \"employeeID\": 4,\"startTime\": \"2020-11-28T16:45:00\", \"endTime\": \"2020-11-28T23:56:00\"}]";
        AllocationsController.Allocation.JsonParse(allocation);

        JSONArray people = PatientsSeenByStaff.GetEmployee();
        assertEquals(2, people.length());
    }

}

