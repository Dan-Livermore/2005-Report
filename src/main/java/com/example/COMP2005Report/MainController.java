package com.example.COMP2005Report;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    String index(){
        return "hi";
    }
}
