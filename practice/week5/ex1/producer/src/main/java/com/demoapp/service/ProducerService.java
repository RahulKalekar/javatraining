package com.demoapp.service;


import org.springframework.kafka.support.SendResult;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    @Autowired
//    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
    @Value("${topic.name}")
    private String topicName;
    public void sendMessage(String message) {
        //send to only partition 0
        //kafkaTemplate.send(topicName,0,null, message);
        //To send an Object


    }
}
