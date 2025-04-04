package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("demo-controller")
public class DemoController {

    @Value("${my-env}")
    private String myEnv;

    private final Environment environment;

    @GetMapping("/active-profile")
    public String activeProfile() {

        String profile = environment.getProperty("spring.profiles.active");

        System.out.println("*** Active Profile " + profile);
        System.out.println("*** DB URL " + environment.getProperty("spring.datasource.url"));
        return profile;
    }

    @GetMapping("/api1")
    public String api1() {
        log.info("*** api1 called");
        System.out.println("*** api1 called");
        return myEnv;
    }

    @GetMapping("/api2")
    public String api2() {
        return "Metin Durmaz";
    }
}
