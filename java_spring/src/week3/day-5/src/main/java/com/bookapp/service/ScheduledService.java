package com.bookapp.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    @Scheduled(fixedRate = 5000)
    public void run() {
        System.out.println("scheduled function is running, Current time is "+ System.currentTimeMillis());

    }
}
