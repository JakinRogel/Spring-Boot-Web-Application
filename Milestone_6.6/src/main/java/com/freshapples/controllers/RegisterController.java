package com.freshapples.controllers;

import com.freshapples.data.UsersDataService;
import com.freshapples.model.UserModel;
import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.freshapples.model.RegisterModel;

/*
 * Class is a controller for /Register, /, /doRegister URLs. /Register is
 * the root directive, / displays the model and creates a new RegisterModel.
 *  /doRegister is called post submission to the / page, it validates the 
 *  data and then submits it to a database 
 * 
 * */

@Controller
@RequestMapping("/Register") // URL returned.
public class RegisterController {
	
	private RegisterModel registerModel;
	private UsersDataService service;
	
	public RegisterController(RegisterModel registerModel, UsersDataService service) { // Constructor to make user.
		super();
		this.registerModel = registerModel;
		this.service = service;
	}
	
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Register Form");
		model.addAttribute("registerModel", registerModel);
		
		return "register"; // Success.
	}
	
	@PostMapping("/doRegister")
	public String doLogin(@Valid RegisterModel registerModel, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Register Form");
			return "register"; // Failure.
		}
		
		int userID = 0;
		
		for(UserModel user : service.findAll()) {
			if(userID <= user.getUser_id())
				userID = user.getUser_id()+1;
		}
		
		String encoded = new BCryptPasswordEncoder().encode(registerModel.getPassword());
		
		//Creates new UserModel object based on entered information
		UserModel user = new UserModel( // Variable names for SQL user added.
				userID,
				registerModel.getUsername(), 
				encoded,
				registerModel.getRole(), 
				registerModel.getEnabled()
				);
		//Adds new user object to MySQL server
		service.create(user);

		System.out.println(String.format("New Registration "
				+ "with userID of %s, and username of %s, Password "
				+ "of %s, Role of %s, Enabled of %s", 
				userID,
				registerModel.getUsername(), 
				encoded,
				registerModel.getRole(), 
				registerModel.getEnabled())); // Allows the client to see all their data. 

		return "home";
	}

}
