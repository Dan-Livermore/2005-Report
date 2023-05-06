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

import static com.example.COMP2005Report.Controller.DateParser.DateParsing;
import static com.example.COMP2005Report.Controller.JsonParser.JsonParse;

public class AdmissionsController {
    public class Admission {
        private static int ID;
        private static Date admissionDate;
        private static Date dischargeDate;
        private static int patientID;

        public int getID() {
            return Admission.ID;
        }

        public Date getAdmissionDate(){
            return Admission.admissionDate;
        }

        public Date getDischargeDate(){
            return Admission.dischargeDate;
        }

        public int getPatientID(){
            return Admission.patientID;
        }

        static HttpURLConnection connection;

        public static int DBConnection() {
            //HTTP URL Connection
            int status = 0;
            BufferedReader reader;
            String line;
            StringBuffer responseContent = new StringBuffer();
            try {
                URL url = new URL("https://web.socem.plymouth.ac.uk/COMP2005/api/Admissions");
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
            JsonParse(responseContent.toString());
            return status;
        }
        
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
}