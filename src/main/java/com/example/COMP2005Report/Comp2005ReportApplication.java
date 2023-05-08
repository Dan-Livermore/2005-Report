package com.example.COMP2005Report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class Comp2005ReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(Comp2005ReportApplication.class, args);
		index();
	}

		@GetMapping("/A")
		static String index(){
			return "slay";
		}
	}
