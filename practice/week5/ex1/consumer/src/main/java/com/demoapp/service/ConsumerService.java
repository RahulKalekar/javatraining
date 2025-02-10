package com.demoapp.service;

import com.demoapp.dto.Product;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

        @KafkaListener(topics = "my_topic", groupId = "my_topic_group_id")
        public void consume(Product product) {
            System.out.println(product);
        }

//    @KafkaListener(topics = "new-hello-topic", groupId = "t-hello2_group-id",topicPartitions =
//            {@TopicPartition(topic="new-hello-topic",partitions={"0"})})
//    public void consumeOfPartitionZero(String message) {
//        System.out.println("000"+message);
//    }
//    @KafkaListener(topics = "new-hello-topic", groupId = "t-hello2_group-id",topicPartitions =
//            {@TopicPartition(topic="new-hello-topic",partitions={"1"})})
//    public void consumeOfPartitionOne(String message) {
//        System.out.println("1111"+message);
//    }
//    @KafkaListener(topics = "new-hello-topic", groupId = "t-hello2_group-id",topicPartitions =
//            {@TopicPartition(topic="new-hello-topic",partitions={"2"})})
//    public void consumeOfPartitionTwo(String message) {
//        System.out.println("2222"+message);
//    }
}
