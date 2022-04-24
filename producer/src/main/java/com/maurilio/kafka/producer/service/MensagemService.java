package com.maurilio.kafka.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

	
	private static String topicBairros;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		System.out.println(topicBairros + "   |   " + message );
		this.kafkaTemplate.send(topicBairros, message);
	}
	
	@Value("${topic.bairros}")
	public void setTopicBairros(String topico) {
		topicBairros = topico;
	}
}
