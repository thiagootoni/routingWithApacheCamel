package com.thiago.testecamel.userApi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.testecamel.userApi.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public Optional<User> findByName(String name);

}
