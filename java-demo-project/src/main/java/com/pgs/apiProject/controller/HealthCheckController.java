package com.pgs.apiProject.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthCheckController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }
}
