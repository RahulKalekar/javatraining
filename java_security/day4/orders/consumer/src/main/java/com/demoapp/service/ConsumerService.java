package com.demoapp.service;


import com.demoapp.dto.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "order-topic", groupId = "order_topic_group_id")
        public void consume(Order order) {
        logger.info("Order received: {}", order);
        try {
            logger.info("Processing order with id: {}", order.getOrderID());
            Thread.sleep(2000);
            logger.info("order with id {} processed successfully.", order.getOrderID());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Error processing order ID {}: {}", order.getOrderID(), e.getMessage());
        }
        }

}
