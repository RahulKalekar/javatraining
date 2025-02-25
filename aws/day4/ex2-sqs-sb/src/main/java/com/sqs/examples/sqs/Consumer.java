package com.sqs.examples.sqs;

import org.springframework.stereotype.Service;

import io.awspring.cloud.sqs.annotation.SqsListener;

@Service
public class Consumer {

	@SqsListener(value="rahul-sqs")
	public void myConsumer(String message) {
		System.out.println("Message received:"+message);
	}
}
