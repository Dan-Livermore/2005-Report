package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;


public class PatientsSeenByStaff {
    public static int GetData() {
        JSONArray employees = EmployeesController.Employee.DBConnection();
//        for (int i = 0; i < employees.length()/2; i++) {
//            System.out.println(employees.getJSONObject(i));
//        }
        JSONArray allocations = AllocationsController.Allocation.DBConnection();
        System.out.println(EmployeesController.Employee.getID());
        System.out.println(EmployeesController.Employee.getSurname());
        System.out.println(EmployeesController.Employee.getForename());
        return 3;
    }
}