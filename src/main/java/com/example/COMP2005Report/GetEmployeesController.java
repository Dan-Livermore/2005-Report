package com.example.COMP2005Report;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class GetEmployeesController {
    public class Employee{
        private static int id;
        private static String surname;
        private static String forename;
    }

    //HTTP URL Connection
    private static HttpURLConnection connection;

    public static void main(String[] args){
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL("https://web.socem.plymouth.ac.uk/COMP2005/api/Employees");
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); //5 secs timeout
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            //System.out.println(status); //Tests if connects. 200 = connected
            if (status > 299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            }
            while((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();
            System.out.print(responseContent);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }
}

