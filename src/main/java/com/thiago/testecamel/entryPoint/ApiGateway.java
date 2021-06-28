package com.thiago.testecamel.entryPoint;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class ApiGateway {
	
	@EndpointInject(value = "direct:hello-world")
	ProducerTemplate testProducer;
	
	@EndpointInject(value = "direct:search-user")
	ProducerTemplate userProducer;
	
	//@EndpointInject(value = "direct:hello-world")
	ConsumerTemplate testConsumer;
	
	@GetMapping
	public ResponseEntity<String> test(){
		
		testProducer.sendBody("");
		return ResponseEntity.ok("fim de fluxo");
	}
	
	@GetMapping(value = "/{userName}")
	public ResponseEntity<String> findUser(@PathVariable String userName){
		
		userProducer.sendBody(userName);
		return ResponseEntity.ok("fim de fluxo");
	}
	
	
}
