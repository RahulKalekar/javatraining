package com.bookapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/log")
    public String logExample() {
        logger.info("INFO: This is an info log");
        logger.debug("DEBUG: Debugging log");
        logger.error("ERROR: An error occurred");

        return "Logging example executed!";
    }
}
