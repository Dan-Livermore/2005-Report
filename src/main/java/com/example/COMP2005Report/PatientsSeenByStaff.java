package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class PatientsSeenByStaff {
    public static int GetData() {
        int connected1 = EmployeesController.Employee.DBConnection();
        int connected2 = AllocationsController.Allocation.DBConnection();
        int empid = EmployeesController.Employee.getID();
        System.out.println(EmployeesController.Employee.getID());
        System.out.println(EmployeesController.Employee.getSurname());
        System.out.println(EmployeesController.Employee.getForename());
        return 3;
    }
}