package com.example.COMP2005Report;

import org.junit.jupiter.api.Test;

import javax.naming.ldap.Control;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {

    @Test
    void index() {
        String expected = "hi"; //arrange
        MainController main = new MainController();
        String actual = main.index();
        assertEquals(expected, actual);
        assertNotEquals("Something else",actual);
    }
}