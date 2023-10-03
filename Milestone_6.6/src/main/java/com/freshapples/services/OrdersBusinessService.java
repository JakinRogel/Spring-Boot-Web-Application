package com.freshapples.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.freshapples.data.DataAccessInterface;
import com.freshapples.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface {

	@Autowired
	private DataAccessInterface<OrderModel> service;
	
	@Override
	public void test() {
		// Placeholder, unnecessary.
		System.out.println("OrderBusinessService is working now!");
		
	}

	@Override
	public List<OrderModel> getOrders() { 
		
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