package com.example.COMP2005Report;

import com.google.gson.*;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

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
                    System.out.print(responseContent);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    connection.disconnect();
                }
                FillGson(responseContent.toString());
                return status;
            }

            public static void FillGson(String jsoninput) {
                Gson gson = new Gson();
                Patient[] patient = gson.fromJson(jsoninput, Patient[].class);
                for (int i=0; i<patient.length; i++) {
                    System.out.println(i);
                    System.out.println(patient[i]);
                }
                System.out.println("hello");
                System.out.println(patient);
            }
        }
    }
}