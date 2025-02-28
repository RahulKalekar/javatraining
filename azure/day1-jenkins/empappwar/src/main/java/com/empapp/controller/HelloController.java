package com.empapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {
    @GetMapping(path="hello")
    public String hello() {
        return "hello bhai bhai bahi from JENKINS"+ LocalDateTime.now();
    }
}
