package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;


public class PatientsSeenByStaff {
    private static JSONArray employees;
    private static JSONArray allocations;
    private static JSONArray admissions;
    private static JSONArray patients;


    public static void GetData() {
        employees = EmployeesController.Employee.DBConnection();
        allocations = AllocationsController.Allocation.DBConnection();
        admissions = AdmissionsController.Admission.DBConnection();
        patients = PatientsController.Patient.DBConnection();
    }

    public static JSONArray GetEmployee(){
        JSONArray people = new JSONArray();

        int empID = 4; //HARD CODED BUT NEEDED!!!!!!!!!!!!!!!
        try {
            for (int emp = 0; emp < employees.length(); emp++) {
                for (int all = 0; all < allocations.length(); all++) {
                    if (employees.getJSONObject(emp).get("id").equals(empID) && allocations.getJSONObject(all).get("employeeID").equals(empID)) {

                        for (int adm = 0; adm < admissions.length(); adm++) {
                            if (allocations.getJSONObject(all).get("admissionID").equals(admissions.getJSONObject(adm).get("id"))) {

                                for (int pat = 0; pat < patients.length(); pat++) {
                                    if (admissions.getJSONObject(adm).get("patientID").equals(patients.getJSONObject(pat).get("id"))) {
                                        System.out.println(patients.getJSONObject(pat));
                                        people.put(patients.getJSONObject(pat));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (NullPointerException e){
            System.out.println("One of the json objects has no length");
        }
        return people;
    }

    public static JSONArray main(){
        GetData();
        return GetEmployee();
    }
}