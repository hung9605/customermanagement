package com.app.customermanagement.service.serviceimpl;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.app.customermanagement.dto.model.PrescriptionDto;
import com.app.customermanagement.service.KafkaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class KafkaServiceImpl implements KafkaService {
	
	private final KafkaTemplate<String, Object> kafkaTemplate;

	@Override
	public void sendMessage(String topic, Object obj) {

		kafkaTemplate.send(topic,obj);
		
	}

}
