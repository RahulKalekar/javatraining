package com.bankapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("home")
    public String home(){
        return "Hello World";
    }
    @GetMapping("admin")
    public String admin(){
        return "Hello Admin";
    }
    @GetMapping("mgr")
    public String mgr(){
        return "Hello Manager";
    }
    @GetMapping("clerk")
    public String clerk(){
        return "Hello Clerk";
    }
}
