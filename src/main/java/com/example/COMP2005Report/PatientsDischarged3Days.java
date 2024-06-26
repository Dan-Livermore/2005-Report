package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PatientsDischarged3Days {


    static JSONArray admissions = AdmissionsController.Admission.DBConnection();
    static JSONArray patients = PatientsController.Patient.DBConnection();
    static JSONArray people = new JSONArray();
    public static void GetData() {
        JSONArray admissions = AdmissionsController.Admission.DBConnection();
        JSONArray patients = PatientsController.Patient.DBConnection();
    }

    public static JSONArray ConvertToDate() {
        // Gets all allocations and separates the start and end dates
        for (int adm = 0; adm < admissions.length(); adm++) {
            Object start = admissions.getJSONObject(adm).get("admissionDate");
            Object end = admissions.getJSONObject(adm).get("dischargeDate");

            // Converts them into date datatype
            LocalDateTime admdate = LocalDateTime.parse(start.toString());
            LocalDate admissiondate = admdate.toLocalDate();

            LocalDateTime disdate = LocalDateTime.parse(end.toString());
            LocalDate dischargedate = disdate.toLocalDate();

            // Calculates if the value is less than 3 and if so adds to the array
            long days = ChronoUnit.DAYS.between(dischargedate, admissiondate);
            if (days <= 3) {
                System.out.println(admissions.getJSONObject(adm));
                String id = admissions.getJSONObject(adm).get("patientID").toString();
                int ID = Integer.parseInt(id);
                people.put(patients.getJSONObject(ID));

            }
        }
        return people;
    }

    public static void main(){
        GetData();
        ConvertToDate();
    }
}