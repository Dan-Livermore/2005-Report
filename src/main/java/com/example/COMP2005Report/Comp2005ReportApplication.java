package com.example.COMP2005Report;

import org.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class Comp2005ReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(Comp2005ReportApplication.class, args);
	}


	@GetMapping("/q1")
	public static String q1(){
		JSONArray output = PatientsSeenByStaff.main();
		return "The patients seen by staff member 4 are " + output.getJSONObject(0);
	}

	@GetMapping("/q2")
	public static String q2(String[] args){
		JSONArray output = PatientsDischarged3Days.GetData();
		return "The patients discharged in under 3 days are:" + output;
	}

	@GetMapping("/q3")
		public static String q3(String[] args){
		ArrayList<String> output = MostAdmissionDay.GetData();
		return "The most common admission day(s) are:" + output;
		}

	@GetMapping("/q4")
	public static String q4(String[] args){
		long output = AverageDuration.GetDuration();
		return "The average duration is :" + output + "minutes";
	}
}

