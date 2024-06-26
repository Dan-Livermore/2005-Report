package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PatientsDischarged3DaysTest {

    @Test
    public void DBConnectionPatientsTest() {
        PatientsDischarged3Days startup = new PatientsDischarged3Days();
        JSONArray output = PatientsDischarged3Days.ConvertToDate();
        assertEquals(200, PatientsController.Patient.getStatus());
        assertNotEquals(0, PatientsController.Patient.getStatus());
    }

    @Test
    public void DBConnectionAdmissionsTest() {
        PatientsDischarged3Days startup = new PatientsDischarged3Days();

        JSONArray output = PatientsDischarged3Days.ConvertToDate();
        assertEquals(200, AdmissionsController.Admission.getStatus());
        assertNotEquals(0, AdmissionsController.Admission.getStatus());
    }


    @Test
    public void ConditionIs3DaysTest() {
        LocalDate dischargedate = LocalDate.of(2020, 10, 13);
        LocalDate admissiondate = LocalDate.of(2020, 10, 10);

        long days = ChronoUnit.DAYS.between(admissiondate, dischargedate);
        System.out.println(days);
        if (days <= 3) {
            System.out.println("Success");
        }
        assertEquals(3L, days);
    }

    @Test
    public void ConditionIsMoreThan3DaysTest() {
        LocalDate dischargedate = LocalDate.of(2020, 10, 14);
        LocalDate admissiondate = LocalDate.of(2020, 10, 10);

        long days = ChronoUnit.DAYS.between(admissiondate, dischargedate);
        System.out.println(days);
        if (days <= 3) {
            System.out.println("Success");
        }
        assertEquals(days, 4L);
    }

    @Test
    public void ConditionIsLessThan3DaysTest() {
        LocalDate dischargedate = LocalDate.of(2020, 10, 12);
        LocalDate admissiondate = LocalDate.of(2020, 10, 10);

        long days = ChronoUnit.DAYS.between(admissiondate, dischargedate);
        if (days <= 3) {
            System.out.println("Success");
        }
        assertEquals(days, 2L);
    }

    @Test
    public void ConditionZeroDaysTest() {
        JSONArray people = new JSONArray();
        LocalDate dischargedate = LocalDate.of(2020, 10, 10);
        LocalDate admissiondate = LocalDate.of(2020, 10, 10);

        long days = ChronoUnit.DAYS.between(dischargedate, admissiondate);
        System.out.println(days);
        if (days <= 3) {
            System.out.println("Success");
        }
        assertEquals(days, 0L);
    }

    @Test
    public void ConditionLeapYearsDaysTest() {
        JSONArray people = new JSONArray();
        LocalDate dischargedate = LocalDate.of(2021, 10, 10);
        LocalDate admissiondate = LocalDate.of(2020, 10, 10);

        long days = ChronoUnit.DAYS.between(admissiondate, dischargedate);
        System.out.println(ChronoUnit.DAYS.between(admissiondate, dischargedate));
        if (days <= 3) {
            System.out.println("Success");
        }
        assertEquals(365L, days);
    }

    @Test
    public void Condition1DayButDiffferentYearsTest() {
        JSONArray people = new JSONArray();
        LocalDate dischargedate = LocalDate.of(2021, 1, 1);
        LocalDate admissiondate = LocalDate.of(2020, 12, 31);

        long days = ChronoUnit.DAYS.between(admissiondate, dischargedate);
        System.out.println(ChronoUnit.DAYS.between(admissiondate, dischargedate));
        if (days <= 3) {
            System.out.println("Success");
        }
        assertEquals(1L, days);
    }

    @Test
    public void ConditionMaxTimeTest() {
        LocalDate dischargedate = LocalDate.of(9999, 12, 31);
        LocalDate admissiondate = LocalDate.of(0001, 1, 1);

        long days = ChronoUnit.DAYS.between(admissiondate, dischargedate);
        System.out.println(ChronoUnit.DAYS.between(admissiondate, dischargedate));
        if (days <= 3) {
            System.out.println("Success");
        }
        assertEquals(3652058L, days);
    }
}