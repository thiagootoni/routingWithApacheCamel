package com.thiago.testecamel.userApi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.testecamel.userApi.dto.UserDto;
import com.thiago.testecamel.userApi.service.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserResource {

	@Autowired
	UserService service;
	
	@GetMapping
	public ResponseEntity<String> test(){
		
		return ResponseEntity.ok("Hello World");
	}
	
	@GetMapping(value = "/{userName}")
	public ResponseEntity<UserDto> findByName(@PathVariable String userName){
		System.out.println("Chegou na api de usuário: Buscando por " + userName);
		return ResponseEntity.ok(this.service.findByName(userName));
	}
	
	
}
