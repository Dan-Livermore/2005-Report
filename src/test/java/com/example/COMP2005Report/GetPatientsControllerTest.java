package com.example.COMP2005Report;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetPatientsControllerTest {

    @Test
    void APIConnection() {
        String expected = "200";
        GetPatientsController main = new GetPatientsController();
        String actual = String.valueOf(GetPatientsController.connection);
        assertEquals(expected, actual);
        assertNotEquals(null, actual);
    }
}