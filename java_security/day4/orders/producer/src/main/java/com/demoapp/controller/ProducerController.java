package com.demoapp.controller;

import com.demoapp.dto.Order;
import com.demoapp.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {
    @GetMapping("/hello")
    public String basicMessage() {
        return "hello";
    }
    @Autowired
    private ProduceService produceService;
    @PostMapping("order")
    public String callProducer(@RequestBody Order order) {
        produceService.produce(order);
        return "order added";
    }
}
