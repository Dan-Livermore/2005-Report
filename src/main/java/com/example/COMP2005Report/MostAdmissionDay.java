package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AdmissionsController;
import org.json.JSONArray;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class MostAdmissionDay {
    public static ArrayList<String> GetData() {
        String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        int[] day = {0, 0, 0, 0, 0, 0, 0};
        JSONArray admissions = AdmissionsController.Admission.DBConnection();
        ArrayList<String> names = null;
        for (int adm = 0; adm < admissions.length(); adm++) {
            String date = admissions.getJSONObject(adm).get("admissionDate").toString();
            System.out.println(date);

            LocalDateTime dischargeDateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);

            String weekday = dischargeDateTime.getDayOfWeek().toString();

            int index = Arrays.asList(days).indexOf(weekday);
            day[index] += 1;

            int max = day[0];

            names = new ArrayList<>();
            names.add("MONDAY");
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
}
