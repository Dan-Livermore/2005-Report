package com.example.COMP2005Report;


import com.example.COMP2005Report.Controller.AdmissionsController;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MostAdmissionDayTest {

    @Test
    public void DBConnectionAdmissionsTest() {
        ArrayList<String> data = MostAdmissionDay.GetData();
        assertEquals(200, AdmissionsController.Admission.getStatus());
        assertNotEquals(0, AdmissionsController.Admission.getStatus());
    }

    @Test
    public void MondayTest() {
        String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        int[] day = {0, 0, 0, 0, 0, 0, 0};

        String date = "2020-01-06T00:00:00";
        LocalDateTime dischargeDateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);

        String weekday = dischargeDateTime.getDayOfWeek().toString();

        int index = Arrays.asList(days).indexOf(weekday);
        day[index] += 1;
        System.out.println(index);

        assertEquals(1,day[0]);
    }

    @Test
    public void TuesdayTest() {
        String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        int[] day = {0, 0, 0, 0, 0, 0, 0};

        String date = "2020-01-07T00:00:00";
        LocalDateTime dischargeDateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);

        String weekday = dischargeDateTime.getDayOfWeek().toString();

        int index = Arrays.asList(days).indexOf(weekday);
        day[index] += 1;
        System.out.println(index);

        assertEquals(1,day[1]);
    }
    @Test
    public void WednesdayTest() {
        String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        int[] day = {0, 0, 0, 0, 0, 0, 0};

        String date = "2020-01-08T00:00:00";
        LocalDateTime dischargeDateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);

        String weekday = dischargeDateTime.getDayOfWeek().toString();

        int index = Arrays.asList(days).indexOf(weekday);
        day[index] += 1;
        System.out.println(index);

        assertEquals(1,day[2]);
    }

    @Test
    public void ThursdayTest() {
        String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        int[] day = {0, 0, 0, 0, 0, 0, 0};

        String date = "2020-01-09T00:00:00";
        LocalDateTime dischargeDateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);

        String weekday = dischargeDateTime.getDayOfWeek().toString();

        int index = Arrays.asList(days).indexOf(weekday);
        day[index] += 1;
        System.out.println(index);

        assertEquals(1,day[3]);
    }

    @Test
    public void FridayTest() {
        String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        int[] day = {0, 0, 0, 0, 0, 0, 0};

        String date = "2020-01-10T00:00:00";
        LocalDateTime dischargeDateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);

        String weekday = dischargeDateTime.getDayOfWeek().toString();

        int index = Arrays.asList(days).indexOf(weekday);
        day[index] += 1;
        System.out.println(index);

        assertEquals(1,day[4]);
    }

    @Test
    public void SaturdayTest() {
        String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        int[] day = {0, 0, 0, 0, 0, 0, 0};

        String date = "2020-01-11T00:00:00";
        LocalDateTime dischargeDateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);

        String weekday = dischargeDateTime.getDayOfWeek().toString();

        int index = Arrays.asList(days).indexOf(weekday);
        day[index] += 1;
        System.out.println(index);

        assertEquals(1,day[5]);
    }

    @Test
    public void SundayTest() {
        String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        int[] day = {0, 0, 0, 0, 0, 0, 0};

        String date = "2020-01-12T00:00:00";
        LocalDateTime dischargeDateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);

        String weekday = dischargeDateTime.getDayOfWeek().toString();

        int index = Arrays.asList(days).indexOf(weekday);
        day[index] += 1;
        System.out.println(index);

        assertEquals(1,day[6]);
    }

    @Test
    public void AllDaysEqual1Test(){
        String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        int[] day = {1, 1, 1, 1, 1, 1, 1};
        int max = day[0];

        ArrayList names = new ArrayList<>();
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
        names.toArray();
        assertEquals(days[0], names.get(0));
        assertEquals(days[1], names.get(1));
        assertEquals(days[2], names.get(2));
        assertEquals(days[3], names.get(3));
        assertEquals(days[4], names.get(4));
        assertEquals(days[5], names.get(5));
        assertEquals(days[6], names.get(6));
    }

    @Test
    public void AllDaysEqualMaxTest(){
        String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        int[] day = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int max = day[0];

        ArrayList names = new ArrayList<>();
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
        names.toArray();
        System.out.println(names);
        System.out.println(days);
        assertEquals(days[0], names.get(0));
        assertEquals(days[1], names.get(1));
        assertEquals(days[2], names.get(2));
        assertEquals(days[3], names.get(3));
        assertEquals(days[4], names.get(4));
        assertEquals(days[5], names.get(5));
        assertEquals(days[6], names.get(6));

    }

}
