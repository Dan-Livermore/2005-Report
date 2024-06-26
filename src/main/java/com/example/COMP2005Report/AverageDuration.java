package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import org.json.JSONArray;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.ArrayList;
import java.util.List;

public class AverageDuration {
    public static JSONArray employees;
    public static JSONArray allocations;
    public static long GetDuration(){
        //Gets required data from API
        employees = EmployeesController.Employee.DBConnection();
        allocations = AllocationsController.Allocation.DBConnection();

        List<Long> duration = new ArrayList<Long>();

        int empID = 4; //HARD CODED BUT NEEDED FOR GETTING DATA!!!!!!!!!!!!!!!

        //Loops through employees and allocations until the employeeID matches
        for (int emp = 0; emp < employees.length(); emp++) {
            for (int all = 0; all < allocations.length(); all++) {
                if (employees.getJSONObject(emp).get("id").equals(empID) && allocations.getJSONObject(all).get("employeeID").equals(empID)) {

                    for (int adm = 0; adm < allocations.length(); adm++) {
                        // Gets times from the JSON objects and converts them into a time data type
                        Object start = allocations.getJSONObject(adm).get("startTime");
                        Object end = allocations.getJSONObject(adm).get("endTime");

                        LocalDateTime starttime = LocalDateTime.parse(start.toString());
                        LocalDateTime endtime = LocalDateTime.parse(end.toString());

                        try {
                            // Calculates time between dates
                            long days = ChronoUnit.MINUTES.between(starttime, endtime);
                            System.out.println(days);
                            duration.add(days);
                        } catch (UnsupportedTemporalTypeException e){
                            // If fails, adds length zero
                            duration.add(0L);
                        }
                    }
                }
            }
        }

        // Perform the mean
        long sum = 0;
        long avg = 0;
        if (duration.size() > 0) {
            for (int i = 0; i < duration.size(); i++) {
                System.out.println(duration.get(i));
                sum += duration.get(i);
            }
            avg = sum / duration.size();
        }
        System.out.println(avg + "minutes");

        return avg;
    }
}
