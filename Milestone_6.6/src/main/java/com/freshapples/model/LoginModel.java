package com.freshapples.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;



/*
 * LoginModel validates and stores data used as the users
 * login information
 * 
 * */
@Service
public class LoginModel {
	// Ensures valid variable lengths are used for username + password.
	@NotNull(message="User name is a required field")
	@Size(min=1, max=32, message="Username must be between 1 and 32 characters")
	private String username;
	
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private String password;
	
	// Getters + setters.

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
