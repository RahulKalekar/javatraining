package com.bookapp.controller;


import com.bookapp.dto.InfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    private InfoDto infoDto;

    @Value("${key.message}")
    private String message;

    @GetMapping("/helloinfo")
    private InfoDto helloInfo() {

        return infoDto;
    }
    @GetMapping("/helloprofile")
    public String hello() {
        return message;
    }

}
