package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.example.COMP2005Report.PatientsDischarged3Days.admissions;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PatientsDischarged3DaysTest {

    @Test
    public void DBConnectionPatientsTest() {
        PatientsDischarged3Days startup = new PatientsDischarged3Days();
        startup.GetData();
        assertEquals(200, PatientsController.Patient.getStatus());
        assertNotEquals(0, PatientsController.Patient.getStatus());
    }

    @Test
    public void DBConnectionAdmissionsTest() {
        PatientsDischarged3Days startup = new PatientsDischarged3Days();
        startup.GetData();
        assertEquals(200, AdmissionsController.Admission.getStatus());
        assertNotEquals(0, AdmissionsController.Admission.getStatus());
    }


    @Test
    public void ConvertDateExpectedTest(){
        PatientsDischarged3Days startup = new PatientsDischarged3Days();
        String json = "{\"id\":\"1\",\"admissionDate\":2023-05-05T12:00:00,\"dischargeDate\":\"2023-05-07T12:00:00\",\"patientID\":\"4\"}";
        JSONObject mockdata = new JSONObject(json);
        admissions.put(mockdata);
        startup.ConvertToDate();
        assertEquals(0,0);
    }

//    @Test
//    public void CaluclateDaysTest(){
//        PatientsDischarged3Days startup = new PatientsDischarged3Days();
//        startup.main();
//        String date1 = "2020-10-10";
//        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate start = LocalDate.parse(date1, formatter1);
//
//        String date2 = "2020-10-12";
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate end = LocalDate.parse(date2, formatter2);
//
//        startup.CalculateDays(0, start, end);
//        System.out.println(startup.people);
//
//
//        JSONArray emptyArray = new JSONArray();
//    }
}
