package com.demoapp.service;

import com.demoapp.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProduceService {
	
	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;
	
	public void produce(Order order) {
		System.out.println("Order sending from producer");
		kafkaTemplate.send("order-topic", order);
	}
}