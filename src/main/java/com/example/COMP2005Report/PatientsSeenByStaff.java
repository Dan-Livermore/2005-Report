package com.example.COMP2005Report;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


@RestController
public class PatientsSeenByStaff {

    public static class GetPatientsController {
        public class Patient {
            private static int ID;
            private static String surname;
            private static String forename;
            private static String nhsnumber;

            public int getID() {
                return Patient.ID;
            }

            public String getSurname() {
                return Patient.surname;
            }

            public String getForename() {
                return Patient.forename;
            }

            public String getNhsNumber() {
                return Patient.nhsnumber;
            }

            static HttpURLConnection connection;

            public static int DBConnection() {
                //HTTP URL Connection
                int status = 0;
                BufferedReader reader;
                String line;
                StringBuffer responseContent = new StringBuffer();
                try {
                    URL url = new URL("https://web.socem.plymouth.ac.uk/COMP2005/api/Patients");
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
                parse(responseContent.toString());
                return status;
            }

            public static String parse(String responseContent) {
                JSONArray patients = new JSONArray(responseContent);
                for (int i = 0; i < patients.length(); i++) {
                    JSONObject patient = patients.getJSONObject(i);
                    int id = patient.getInt("id");
                    String surname = patient.getString("surname");
                    String forename = patient.getString("forename");
                    String nhs = patient.getString("nhsNumber");
                    System.out.println(id + "," + surname + "," + forename + "," + nhs);
                }
                return "Yowza";
            }
        }
    }
}