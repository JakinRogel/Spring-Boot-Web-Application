package com.freshapples.services;

import java.util.List;
import com.freshapples.model.OrderModel;

public interface OrdersBusinessServiceInterface {
	
	public void test();
	public List<OrderModel> getOrders();
	public void init();
	public void destroy();
}