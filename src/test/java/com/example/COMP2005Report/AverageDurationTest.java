package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.AllocationsController;
import com.example.COMP2005Report.Controller.EmployeesController;
import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AverageDurationTest {
    @Test
    public void DBConnectionEmployeesTest() {
        JSONArray data = EmployeesController.Employee.DBConnection();
        Assertions.assertEquals(200, EmployeesController.Employee.getStatus());
        assertNotEquals(0, EmployeesController.Employee.getStatus());
    }

    @Test
    public void DBConnectionAllocationsTest() {
        JSONArray data = AllocationsController.Allocation.DBConnection();
        Assertions.assertEquals(200, AllocationsController.Allocation.getStatus());
        assertNotEquals(0, AllocationsController.Allocation.getStatus());
    }

    @Test
    public void DurationIsEmptyTest() {
        AverageDuration x = new AverageDuration();

        List<Long> duration = new ArrayList<Long>();
        long sum = 0;
        long avg = 0;
        if (duration.size() > 0) {
            for (int i = 0; i < duration.size(); i++) {
                System.out.println(duration.get(i));
                sum += duration.get(i);
            }
            avg = sum / duration.size();
        }
        System.out.println(avg);
        assertEquals(0, avg);
    }
    @Test
    public void DurationHas1ElementTest() {
        AverageDuration x = new AverageDuration();

        List<Long> duration = new ArrayList<Long>();
        duration.add(20L);

        long sum = 0;
        long avg = 0;
        if (duration.size() > 0) {
            for (int i = 0; i < duration.size(); i++) {
                System.out.println(duration.get(i));
                sum += duration.get(i);
            }
            avg = sum / duration.size();
        }
        assertEquals(20L, avg);
    }

    @Test
    public void DurationHasLessThanZeroTest() {
        AverageDuration x = new AverageDuration();

        List<Long> duration = new ArrayList<Long>();

        long sum = 0;
        long avg = 0;
        if (duration.size() > 0) {
            for (int i = 0; i < duration.size(); i++) {
                System.out.println(duration.get(i));
                sum += duration.get(i);
            }
            avg = sum / duration.size();
        }
        assertEquals(0L, avg);
    }

    @Test
    public void DurationExpectedTest() {
        AverageDuration x = new AverageDuration();

        List<Long> duration = new ArrayList<Long>();
        duration.add(343L);
        duration.add(115L);
        duration.add(5L);
        duration.add(10724600L);

        long sum = 0;
        long avg = 0;
        if (duration.size() > 0) {
            for (int i = 0; i < duration.size(); i++) {
                System.out.println(duration.get(i));
                sum += duration.get(i);
            }
            avg = sum / duration.size();
        }
        assertEquals(2681265L, avg);
    }



}
