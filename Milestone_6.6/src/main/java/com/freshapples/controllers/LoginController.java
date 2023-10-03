package com.freshapples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



/*
 * Login Controller directs the mapping for GET requests
 * sent to the root URI and redirect to /dologin upon successful
 * submission. Purpose is to log the user from the UserModel into 
 * the application through validation in the database.
 * 
 * */
@Controller
public class LoginController {

	@GetMapping("/login")
	public String display(Model model)
	{
		model.addAttribute("title", "Login Form");
		return "login";
	}
}