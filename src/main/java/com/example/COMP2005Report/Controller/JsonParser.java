package com.example.COMP2005Report.Controller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;

import static com.example.COMP2005Report.Controller.DateParser.DateParsing;

public class JsonParser {
    public static JSONArray JsonParse(String data) {
        JSONArray allocations = new JSONArray(data);
        for (int i = 0; i < allocations.length(); i++) {
            JSONObject allocation = allocations.getJSONObject(i);
            int id = allocation.getInt("id");
            int admissionid = allocation.getInt("admissionID");
            int employeeid = allocation.getInt("employeeID");
            String startTime = allocation.getString("startTime");
            Date starttime = DateParsing(startTime);
            String endTime = allocation.getString("endTime");
            Date endtime = DateParsing(endTime);
        }
        return allocations;
    }
}
