package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import org.json.JSONArray;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class MostAdmissionDay {
    private static JSONArray admissions;
    public static ArrayList<String> GetData() {
        // Creates arrays to compare names and increment values.
        String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        int[] day = {0, 0, 0, 0, 0, 0, 0};

        // Connecting to API
        admissions = AdmissionsController.Admission.DBConnection();
        ArrayList<String> names = null;

        // Iterates through the days to add each one to the list
        for (int adm = 0; adm < admissions.length(); adm++) {
            // Converts JSON object into date
            String date = admissions.getJSONObject(adm).get("admissionDate").toString();
            System.out.println(date);
            LocalDateTime dischargeDateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
            // date becomes day of the week
            String weekday = dischargeDateTime.getDayOfWeek().toString();

            // Adds 1 to the corresponding day in the array
            int index = Arrays.asList(days).indexOf(weekday);
            day[index] += 1;

            // Sets default day to Monday (as its the first day)
            int max = day[0];
            names = new ArrayList<>();
            names.add("MONDAY");
            // Iterates through days and if one is higher than previous, it replaces the value in the array
            for (int i = 1; i < day.length; i++) {
                if (day[i] > max) {
                    max = day[i];
                    names.clear();
                    names.add(days[i]);
                } else if (day[i] == max) {
                    names.add(days[i]);
                }
            }
            System.out.println(names);
        }
        return names;
    }


    public static void main(){
        GetData();
    }
}
