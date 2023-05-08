package com.example.COMP2005Report.Controller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AllocationsController {
    public class Allocation {
        private static int ID;
        private static int admissionID;
        private static int employeeID;
        private static Date startTime;
        private static Date endTime;

        public int getID() {
            return Allocation.ID;
        }

        public int getAdmissionID() {
            return Allocation.admissionID;
        }

        public int getEmployeeID() {
            return Allocation.employeeID;
        }

        public static Date getStartTime() {
            return startTime;
        }

        public static Date getEndTime() {
            return endTime;
        }



        static HttpURLConnection connection;
        static int status = 0;
        public static int getStatus() {
            return status;
        }

        public static JSONArray DBConnection() {
            //HTTP URL Connection
            BufferedReader reader;
            String line;
            StringBuffer responseContent = new StringBuffer();
            try {
                URL url = new URL("https://web.socem.plymouth.ac.uk/COMP2005/api/allocations");
                connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000); //5 secs timeout
                connection.setReadTimeout(5000);


                status = connection.getResponseCode();
                if (status > 299) {
                    reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                } else {
                    reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));
                }
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }
            JSONArray data = JsonParse(responseContent.toString());
            return data;
        }


        public static JSONArray JsonParse(String data) {
            JSONArray allocations = new JSONArray(data);
            for (int i = 0; i < allocations.length(); i++) {
                JSONObject allocation = allocations.getJSONObject(i);
                int id = allocation.getInt("id");
                int admissionid = allocation.getInt("admissionID");
                int employeeid = allocation.getInt("employeeID");
                String startTime = allocation.getString("startTime");
                String endTime = allocation.getString("endTime");
            }
            return allocations;
        }
    }
}