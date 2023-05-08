package com.example.COMP2005Report;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class Q1IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Comp2005ReportApplication  application;
//    @Test
//    void GetIntendedResult() {
//        when(Comp2005ReportApplication.q1());
//        .thenreturn()
//
//    }
}