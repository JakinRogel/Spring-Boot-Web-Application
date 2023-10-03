package com.freshapples.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.freshapples.data.DataAccessInterface;
import com.freshapples.model.UserModel;

public class UsersBusinessService implements UsersBusinessServiceInterface {

	@Autowired
	private DataAccessInterface<UserModel> service;
	
	@Override
	public void test() {
		// Placeholder, unnecessary.
		System.out.println("UsersBusinessService is working now!");
		
	}

	@Override
	public List<UserModel> getUsers() { 
		
		return service.findAll();
	}
	
	@Override
	public void init() {
		System.out.println("init() method call");
		
	}

	@Override
	public void destroy() {
		System.out.println("destroy() method call");
		
	}

}