package com.maurilio.kafka.producer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maurilio.kafka.producer.service.MensagemService;

@RestController
@RequestMapping("/mensagem")
public class MensagemResource {

	@Autowired
	MensagemService mensagemService;
	
	@PostMapping
	public ResponseEntity<String> enviarMensagem(@RequestBody String mensagem){
		mensagemService.sendMessage(mensagem);
		return ResponseEntity.ok().body("Mensagem enviada: " + mensagem);
		
	}
}
