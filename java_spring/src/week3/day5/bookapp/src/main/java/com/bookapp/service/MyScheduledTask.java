package com.bookapp.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduledTask {

    @Scheduled(fixedRate = 5000) // 5secs
    public void runTask() {
        System.out.println("Task executed every 5 seconds");
    }
}
