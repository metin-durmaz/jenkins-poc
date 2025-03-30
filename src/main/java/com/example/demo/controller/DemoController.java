package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo-controller")
public class DemoController {

    @Value("${my-env}")
    private String myEnv;

    @GetMapping("/api1")
    public String api1() {
        return myEnv;
    }

    @GetMapping("/api2")
    public String api2() {
        return "Metin Durmaz";
    }
}
