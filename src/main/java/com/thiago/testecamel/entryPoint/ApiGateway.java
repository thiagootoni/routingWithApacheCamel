package com.thiago.testecamel.entryPoint;

import org.apache.camel.EndpointInject;
import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thiago.testecamel.entryPoint.dto.UserDto;

@RestController
@RequestMapping(value = "/users")
public class ApiGateway {

	@EndpointInject(value = "direct:hello-world")
	ProducerTemplate testProducer;

	@EndpointInject(value = "direct:search-user")
	FluentProducerTemplate userProducer;

	@GetMapping
	public ResponseEntity<String> test() {

		String response = (String) testProducer.requestBody("");

		System.out.println(response);

		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/{userName}")
	public ResponseEntity<?> findUser(@PathVariable String userName)  {
		
		Object response = userProducer.withBody(userName).request();
		System.out.println("Respota na Api gateway: " + response.toString());
		
		return ResponseEntity.ok(response);
		
	}

}
