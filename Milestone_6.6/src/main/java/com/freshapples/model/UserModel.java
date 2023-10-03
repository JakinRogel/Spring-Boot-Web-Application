package com.freshapples.model;


/*
 * UserModel creates variables for pertinent information 
 * needed from users. This information is populated through 
 * the RegisterModel
 * 
 * */

public class UserModel {
	
	// All universally used information for account creation.
	private String username, password, role;
	private int user_id, enabled;
	
	// Constructor.
	public UserModel(int user_id, String username, String password, String role, int enabled) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}

	// Getters + setters.
	public int getUser_id() {
		return user_id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public int getEnabled() {
		return enabled;
	}


	
	

}
