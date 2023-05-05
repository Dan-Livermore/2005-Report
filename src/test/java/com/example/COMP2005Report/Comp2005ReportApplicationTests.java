package com.example.COMP2005Report;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class Comp2005ReportApplicationTests {

	@Test
	void index(){
		String expected = "hi"; //arrange
		main x = new main();
		String actual = x.index();
		assertEquals(expected, actual);
		assertNotEquals("Something else",actual);
	}

}
