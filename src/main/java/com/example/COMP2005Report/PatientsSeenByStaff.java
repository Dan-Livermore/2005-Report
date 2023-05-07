package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;


public class PatientsSeenByStaff {
    public static int GetData() {
        JSONArray employees = EmployeesController.Employee.DBConnection();
        JSONArray allocations = AllocationsController.Allocation.DBConnection();
        JSONArray admissions = AdmissionsController.Admission.DBConnection();
        JSONArray patients = PatientsController.Patient.DBConnection();

        int empID = 4; //HARD CODED BUT NEEDED!!!!!!!!!!!!!!!

        for (int emp = 0; emp < employees.length(); emp++) {
            for (int all = 0; all < allocations.length(); all++) {
                if (employees.getJSONObject(emp).get("id").equals(empID) && allocations.getJSONObject(all).get("employeeID").equals(empID)) {

                    for (int adm = 0; adm < admissions.length(); adm++) {
                        if (allocations.getJSONObject(all).get("admissionID").equals(admissions.getJSONObject(adm).get("id"))) {

                            for (int pat = 0; pat < patients.length(); pat++){
                                if (admissions.getJSONObject(adm).get("patientID").equals(patients.getJSONObject(pat).get("id"))){
                                    System.out.println(patients.getJSONObject(pat));
                                }
                            }
                        }
                    }
                }
            }
        }
        return 3;
    }
}