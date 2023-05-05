package com.example.COMP2005Report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class Comp2005ReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(Comp2005ReportApplication.class, args);
	}
	private static void sendGETRequest() throws IOException {
		URL url = new URL("https://web.socem.plymouth.ac.uk/COMP2005/api/Patients");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		}

	}

