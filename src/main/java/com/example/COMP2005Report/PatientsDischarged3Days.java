package com.example.COMP2005Report;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Allocation")
public class PatientsDischarged3Days {
    @GetMapping("/get")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getAllocation(){
        return "Hey";
    }

}
