package com.app.customermanagement.service.serviceimpl;

import java.util.concurrent.CompletableFuture;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import com.app.customermanagement.service.KafkaService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class KafkaServiceImpl implements KafkaService {
	
	private final KafkaTemplate<String, Object> kafkaTemplate;

	@Override
	public CompletableFuture<SendResult<String, Object>> sendMessage(String topic, Object obj) {
		return kafkaTemplate.send(topic,obj);
	}

}
