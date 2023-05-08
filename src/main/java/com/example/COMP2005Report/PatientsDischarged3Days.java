package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class PatientsDischarged3Days {

    static JSONArray admissions = AdmissionsController.Admission.DBConnection();
    static JSONArray patients = PatientsController.Patient.DBConnection();
    static JSONArray people = new JSONArray();
    public static JSONArray GetData() {

        for (int adm = 0 ; adm < admissions.length(); adm++){
            Object start = admissions.getJSONObject(adm).get("admissionDate");
            Object end = admissions.getJSONObject(adm).get("dischargeDate");


            LocalDateTime admdate = LocalDateTime.parse(start.toString());
            LocalDate admissiondate = admdate.toLocalDate();
            System.out.println(admissiondate);

            LocalDateTime disdate = LocalDateTime.parse(end.toString());
            LocalDate dischargedate = disdate.toLocalDate();
            System.out.println(dischargedate);
            long days = ChronoUnit.DAYS.between(dischargedate, admissiondate);
            if (days > 3){
                System.out.println(admissions.getJSONObject(adm));
                String id = admissions.getJSONObject(adm).get("patientID").toString();
                int ID = Integer.parseInt(id);
                System.out.println("HELP");
                System.out.println(patients.getJSONObject(ID));
                System.out.println("DONE");
                people.put(patients.getJSONObject(ID));

            }

        }
        return people;
    }
}