package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class PatientsDischarged3Days {
    public static JSONArray admissions;
    public static JSONArray patients;
    public static JSONArray people = new JSONArray();
    public static void GetData() {
        admissions = AdmissionsController.Admission.DBConnection();
        patients = PatientsController.Patient.DBConnection();
    }

    public static void ConvertToDate(){
        for (int adm = 0 ; adm < admissions.length(); adm++){
            Object start = admissions.getJSONObject(adm).get("admissionDate");
            Object end = admissions.getJSONObject(adm).get("dischargeDate");


            LocalDateTime admdate = LocalDateTime.parse(start.toString());
            LocalDate admissiondate = admdate.toLocalDate();
            System.out.println(admissiondate);

            LocalDateTime disdate = LocalDateTime.parse(end.toString());
            LocalDate dischargedate = disdate.toLocalDate();
            System.out.println(dischargedate);
            CalculateDays(adm, admissiondate, dischargedate);
        }
    }

    public static void CalculateDays(int adm, LocalDate dischargedate, LocalDate admissiondate){
        long days = ChronoUnit.DAYS.between(dischargedate, admissiondate);
        if (days > 3){
            System.out.println(admissions.getJSONObject(adm));
            people.put(admissions.getJSONObject(adm));
        }
    }

    public static void DisplayDays(){}

    public static void main(){
        GetData();
        ConvertToDate();
        DisplayDays();
    }
}