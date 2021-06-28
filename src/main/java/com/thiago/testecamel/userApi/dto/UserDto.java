package com.thiago.testecamel.userApi.dto;

import java.io.Serializable;

import com.thiago.testecamel.userApi.entities.User;

public class UserDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String githubUserName;

	public UserDto() {
		super();
	}

	public UserDto(Long id, String nome, String githubUserName) {
		super();
		this.id = id;
		this.nome = nome;
		this.githubUserName = githubUserName;
	}
	
	public UserDto(User user) {
		this(user.getId(), user.getName(), user.getGithubUserName());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGithubUserName() {
		return githubUserName;
	}

	public void setGithubUserName(String githubUserName) {
		this.githubUserName = githubUserName;
	}
	
	
}
