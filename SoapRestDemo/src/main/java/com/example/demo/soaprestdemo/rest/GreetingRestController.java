package com.example.demo.soaprestdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

    @GetMapping("/api/greeting")
    public String greeting() {
        return "Hello from REST!";
    }
}
