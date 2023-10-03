package com.freshapples.services;

import java.util.List;
import com.freshapples.model.UserModel;

public interface UsersBusinessServiceInterface {
	
	public void test();
	public List<UserModel> getUsers();
	public void init();
	public void destroy();
}