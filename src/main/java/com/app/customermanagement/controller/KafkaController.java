//package com.app.customermanagement.controller;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.customermanagement.config.KafkaProducer;
//
//@RestController
//@RequestMapping("/kafka")
//@CrossOrigin("*")
//public class KafkaController {
//
//	    private final KafkaProducer kafkaProducer;
//
//	    public KafkaController(KafkaProducer kafkaProducer) {
//	        this.kafkaProducer = kafkaProducer;
//	    }
//
//	    @GetMapping("/send")
//	    public String sendMessage(@RequestParam
//	    		("msg") String message) {
//	        kafkaProducer.sendMessage("register-topic", message);
//	        return "Message sent to Kafka topic";
//	    }
//	
//
//}
