package com.example.COMP2005Report.Controller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.example.COMP2005Report.Controller.JsonParser.JsonParse;

public class EmployeesController {
    public class Employee {
        private static int ID;
        private static String surname;
        private static String forename;

        public int getID() {
            return Employee.ID;
        }

        public String getSurname() {
            return Employee.surname;
        }

        public String getForename() {
            return Employee.forename;
        }

        static HttpURLConnection connection;

        public static int DBConnection() {
            //HTTP URL Connection
            int status = 0;
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
            JsonParse(responseContent.toString());
            return status;
        }
    }
}
