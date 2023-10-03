package com.freshapples.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Service;




/*
 * RegisterModel validates and stores data used as the registration 
 * information for the user
 * 
 * */

@Service
public class RegisterModel {
	// Makes sure lengths are valid for the table.

	private int user_id = 0;
	@NotNull(message="Username is a required field")
	@Size(min=1, max=32, message="Last name must be between 1 and 32 characters")
	private String username;
	@NotNull(message="Password is a required field")
	@Size(min=1, max=100, message="Email Address must be between 1 and 100 characters")
	private String password;
	
	private String role = "ROLE_USER";
	
	private int enabled = 1;

	
	// Getters + setters.
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
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
	public String getRole() {
		return role;
	}
	public int getEnabled() {
		return enabled;
	}




}
