package com.example.COMP2005Report.Controller;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import static com.example.COMP2005Report.Controller.DateParser.DateParsing;

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
        static int status = 0;
        public static int getStatus() {
            return AdmissionsController.Admission.status;
        }

        public static int DBConnection() {
            //HTTP URL Connection
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
            JSONArray admissions = new JSONArray(data);
            for (int i = 0; i < admissions.length(); i++) {
                JSONObject admission = admissions.getJSONObject(i);
                int id = admission.getInt("id");
                String admissionDate = admission.getString("admissionDate");
                Date admissiondate = DateParsing(admissionDate);
                String dischargeDate = admission.getString("dischargeDate");
                Date dischargedate = DateParsing(dischargeDate);
                int patientID = admission.getInt("patientID");
            }
            return admissions;
        }
    }
}