package com.demoapp.controller;

import com.demoapp.dto.Product;
import com.demoapp.service.ProduceService;
import com.demoapp.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {
    private ProducerService producerService;
    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }
    @GetMapping("/hello")
    public String basicMessage() {
        return "hello";
    }
    @GetMapping("/hello/{message}")
    public void sendMessage(@PathVariable String message) {
        for(int i=0;i<5000;i++){
            producerService.sendMessage(message+" "+i);
        }
    }
    @Autowired
    private ProduceService produceService;
    @PostMapping("producer")
    public String callProducer(@RequestBody Product product) {
        produceService.produce(product);
        return "product added";
    }
}
