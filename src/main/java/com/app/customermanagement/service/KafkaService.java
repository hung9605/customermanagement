package com.app.customermanagement.service;

public interface KafkaService {
	
	void sendMessage(String topic, Object obj);

}
