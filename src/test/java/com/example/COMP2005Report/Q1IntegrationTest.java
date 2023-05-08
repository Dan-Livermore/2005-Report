package com.example.COMP2005Report;

import com.example.COMP2005Report.Controller.EmployeesController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class Q1IntegrationTest {
    @RunWith(SpringRunner.class) // JUnit runner for Spring Boot tests
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    // Load the Spring Boot context with a random port
    public class UserControllerIntegrationTest {

        @Autowired
        private TestRestTemplate restTemplate; // TestRestTemplate is a Spring Boot class for testing REST endpoints

//        @Test
//        public void GetEmployeesTest() throws Exception {
//
//            // When
//            ResponseEntity<EmployeesController.Employee> response = restTemplate.getForEntity("q1" + EmployeesController.class);
//
//            // Then
//            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//            assertThat(response.getBody().getId()).isEqualTo("4");
//            //assertThat(response.getBody().getName()).isEqualTo("John Doe"); // assume this is the expected name
//        }
//    }
    }
}