package com.example.COMP2005Report;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.juli.logging.Log;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.HandlerExecutionChain;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(PatientsSeenByStaff.class)
class IntegrationTestPatientsSeenByStaff {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void Q1IntegrationTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/q1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void Q2IntegrationTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/q2"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void Q3IntegrationTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/q3"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void Q4IntegrationTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/q4"))
                .andExpect(status().isOk())
                .andReturn();
    }
}

