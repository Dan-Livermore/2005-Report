package com.example.COMP2005Report;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class Comp2005ReportApplicationTests {

	@Test
	void index(){
		String expected = "200"; // Successful connection
		PatientsSeenByStaff output = new PatientsSeenByStaff();
		String actual = output.index();
		assertEquals(expected, actual);
		assertNotEquals("300",actual);
	}

}
