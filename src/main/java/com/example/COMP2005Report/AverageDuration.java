package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.ArrayList;
import java.util.List;

public class AverageDuration {
    public static JSONArray employees;
    public static JSONArray allocations;
    public static List<Long> duration = new ArrayList<Long>();
    public static void GetData() {
        employees = EmployeesController.Employee.DBConnection();
        allocations = AllocationsController.Allocation.DBConnection();

        int empID = 4; //HARD CODED BUT NEEDED!!!!!!!!!!!!!!!

        for (int emp = 0; emp < employees.length(); emp++) {
            for (int all = 0; all < allocations.length(); all++) {
                if (employees.getJSONObject(emp).get("id").equals(empID) && allocations.getJSONObject(all).get("employeeID").equals(empID)) {
                    ConvertToTime();
                }
            }
        }
    }


    public static void ConvertToTime(){
        for (int adm = 0; adm < allocations.length(); adm++){

        Object start=allocations.getJSONObject(adm).get("startTime");
        Object end=allocations.getJSONObject(adm).get("endTime");

        LocalDateTime starttime = LocalDateTime.parse(start.toString());
        LocalDateTime endtime = LocalDateTime.parse(end.toString());
        CalculateDuration(starttime, endtime);
        }
    }

    public static void CalculateDuration(LocalDateTime starttime, LocalDateTime endtime){
        long days = ChronoUnit.MINUTES.between(starttime, endtime);
        System.out.println(days);
        duration.add(days);
    }
    public static void CalculateAverage(){
        long sum = 0;
        for (int i = 0; i < duration.size(); i++){
            System.out.println(duration.get(i));
            sum += duration.get(i);
        }
        long avg = sum / duration.size();
        System.out.println(avg + "minutes");
    }
    public static void main(){
        GetData();
        ConvertToTime();
        CalculateAverage();
    }
}
