package com.app.customermanagement.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.support.SendResult;

public interface KafkaService {
	
	CompletableFuture<SendResult<String, Object>> sendMessage(String topic, Object obj);

}