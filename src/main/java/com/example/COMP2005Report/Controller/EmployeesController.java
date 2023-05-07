package com.example.COMP2005Report.Controller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class EmployeesController {
    public static class Employee {
        private static int ID;
        private static String surname;
        private static String forename;

        public static int getID() {
            return Employee.ID;
        }

        public static String getSurname() {
            return Employee.surname;
        }

        public static String getForename() {
            return Employee.forename;
        }


        static HttpURLConnection connection;
        static int status = 0;
        public static int getStatus() {
            return Employee.status;
        }

        public static JSONArray DBConnection() {
            //HTTP URL Connection
            BufferedReader reader;
            String line;
            StringBuffer responseContent = new StringBuffer();
            try {
                URL url = new URL("https://web.socem.plymouth.ac.uk/COMP2005/api/employees");
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
            JSONArray employees = new JSONArray(data);
            for (int i = 0; i < employees.length(); i++) {
                JSONObject employee = employees.getJSONObject(i);
                int id = employee.getInt("id");
                String surname = employee.getString("surname");
                String forename = employee.getString("forename");
            }
            return employees;
        }
    }
}
