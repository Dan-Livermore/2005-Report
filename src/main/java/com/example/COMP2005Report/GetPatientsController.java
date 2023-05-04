package com.example.COMP2005Report;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetPatientsController {
    private class Patient {
        int ID;
        String surname;
        String forename;
        String nhsnumber;
    }

    static HttpURLConnection connection;

    public static void main(String[] args) {
        //HTTP URL Connection
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL("https://web.socem.plymouth.ac.uk/COMP2005/api/Patients");
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); //5 secs timeout
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            //System.out.println(status); //Tests if connects. 200 = connected
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            }
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();
            System.out.print(responseContent);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        Gson gson = new Gson();
        Patient patient = gson.fromJson(responseContent.toString(), Patient.class);
    }
}



