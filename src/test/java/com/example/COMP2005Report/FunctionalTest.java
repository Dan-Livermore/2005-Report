package com.example.COMP2005Report;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class FunctionalTest {

    @Autowired
    private MockMvc mock;

    @Test
    void OutputQ1Test() throws Exception{
        String x = mock.perform(get("/q1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals("The patients seen by staff member 4 are {\"forename\":\"Heather\",\"surname\":\"Carter\",\"id\":2,\"nhsNumber\":\"2224446666\"}",x);
    }

    @Test
    void OutputQ2Test() throws Exception{
        String x = mock.perform(get("/q2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals("The patients discharged in under 3 days are:[{\"forename\":\"Nicky\",\"surname\":\"Barnes\",\"id\":3,\"nhsNumber\":\"6663338888\"},{\"forename\":\"Nicky\",\"surname\":\"Barnes\",\"id\":3,\"nhsNumber\":\"6663338888\"}]",x);
    }
    @Test
    void OutputQ3Test() throws Exception{
        String x = mock.perform(get("/q3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals("The most common admission day(s) are:[MONDAY, THURSDAY, SATURDAY]",x);
    }

    @Test
    void OutputQ4Test() throws Exception{
        String x = mock.perform(get("/q4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals("The average duration is :575minutes",x);
    }
}
