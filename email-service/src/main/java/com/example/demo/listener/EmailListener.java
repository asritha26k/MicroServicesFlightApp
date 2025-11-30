package com.example.demo.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailListener {

	@KafkaListener(topics = "ticket-booked", groupId = "email-group")
	public void listen(String message) {
		System.out.println("📩 Email-service received: " + message);
	}
}
