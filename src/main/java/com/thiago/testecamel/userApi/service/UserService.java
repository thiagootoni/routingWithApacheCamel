package com.thiago.testecamel.userApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.testecamel.userApi.dto.UserDto;
import com.thiago.testecamel.userApi.entities.User;
import com.thiago.testecamel.userApi.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public UserDto findByName(String userName) {
		
		User user = this.repository.findByName(userName)
				.orElseThrow(() -> new IllegalArgumentException("usuário não encontrado"));
		
		return new UserDto(user);
	}
	
}
