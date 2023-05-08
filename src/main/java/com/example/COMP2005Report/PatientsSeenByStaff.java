package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PatientsSeenByStaff {

    private static JSONArray employees;
    private static JSONArray allocations;
    private static JSONArray admissions;
    private static JSONArray patients;

    public static int empID =4;//HARD CODED BUT NEEDED!!!!!!!!!!!!!!!

    public static void GetID(String ID){
        empID = Integer.parseInt(ID);
    }
    public static void GetData() {
        employees = EmployeesController.Employee.DBConnection();
        allocations = AllocationsController.Allocation.DBConnection();
        admissions = AdmissionsController.Admission.DBConnection();
        patients = PatientsController.Patient.DBConnection();
    }
    public static void SelectEmpID(){
        for (int emp = 0; emp < employees.length(); emp++) {
            for (int all = 0; all < allocations.length(); all++) {
                if (employees.getJSONObject(emp).get("id").equals(empID) && allocations.getJSONObject(all).get("employeeID").equals(empID)) {
                    SelectAdmissions(all);
                }
            }
        }
    }

    public static void SelectAdmissions(int all){
        for (int adm = 0; adm < admissions.length(); adm++) {
            if (allocations.getJSONObject(all).get("admissionID").equals(admissions.getJSONObject(adm).get("id"))) {
                DisplayPatients(adm);
            }
        }
    }

    @GetMapping("/Q1")
    public static JSONArray DisplayPatients(int adm){
        JSONArray allpatients = new JSONArray();
        for (int pat = 0; pat < patients.length(); pat++){
            if (admissions.getJSONObject(adm).get("patientID").equals(patients.getJSONObject(pat).get("id"))){
                System.out.println(patients.getJSONObject(pat));
                allpatients.put(patients.getJSONObject(pat));
            }
        }
        return allpatients;
    }

    public static void main(){
        //GetID(String ID);
        GetData();
        SelectEmpID();
    }
}