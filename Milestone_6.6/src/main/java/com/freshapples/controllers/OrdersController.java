package com.freshapples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.freshapples.model.OrderModel;
import com.freshapples.services.OrdersBusinessServiceInterface;

@Controller
public class OrdersController {
	
	public OrdersController(OrdersBusinessServiceInterface service) {
		// Constructor paired with SpringConfig.java.
		super();
		this.service = service;
	}
	
	OrdersBusinessServiceInterface service;
	@GetMapping("/orders")
	public String showAllOrders(Model model){ // For display of orders.
		
		List<OrderModel> orders = service.getOrders();
	
		model.addAttribute("title", "Movies sold");
		model.addAttribute("orders", orders);
		
		return "orders.html";
	}
}