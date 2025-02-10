package com.demoapp.service;

import com.demoapp.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProduceService {
	
	@Autowired
	private KafkaTemplate<String, Product> kafkaTemplate;
	
	public void produce(Product product) {
		System.out.println("message is send....");
		kafkaTemplate.send("my_topic", product);
	}
}