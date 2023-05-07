package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import com.example.COMP2005Report.Controller.PatientsController;
import org.json.JSONArray;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class MostAdmissionDay {
    public static JSONArray admissions;

    public static String[] days = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
    public static int[] day = {0,0,0,0,0,0,0};

    public static ArrayList<String> names = new ArrayList<>();
    public static void GetData() {
        admissions = AdmissionsController.Admission.DBConnection();
    }

    private static void ConvertDay() {

        for (int adm = 0; adm < admissions.length(); adm++) {
            String date = admissions.getJSONObject(adm).get("admissionDate").toString();
            // Parse the date string into a LocalDateTime object
            LocalDateTime dischargeDateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);

            // Get the day of the week as a string
            String weekday = dischargeDateTime.getDayOfWeek().toString();
            int index = Arrays.asList(days).indexOf(weekday);
            day[index] += 1;
            CalculateFrequentDay();
        }
    }

    private static void CalculateFrequentDay() {
        int max = day[0]; // Assume the first number is the maximum


        names.add("MONDAY");
        for (int i = 1; i < day.length; i++) {
            if (day[i] > max) {
                max = day[i];
                names.clear(); // Reset the list since a new maximum is found
                names.add(days[i]); // Add the new maximum's index to the list
            } else if (day[i] == max) {
                names.add(days[i]); // Add the index to the list if it has the same value as the current maximum
            }
        }
    }
    private static void DisplayDays() {
        System.out.println(names);
    }


    public static void main(){
        GetData();
        ConvertDay();
        CalculateFrequentDay();
        DisplayDays();
    }
}
