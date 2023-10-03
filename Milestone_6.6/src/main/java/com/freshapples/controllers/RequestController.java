package com.freshapples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Class is a controller for /Register, /, /doRegister URLs. /Register is
 * the root directive, / displays the model and creates a new RegisterModel.
 *  /doRegister is called post submission to the / page, it validates the 
 *  data and then submits it to a database 
 * 
 * */

@Controller
@RequestMapping("/") // For accessing page via the navbar.
public class RequestController {
	@GetMapping("/request")
	public String display(Model model) {
		return "request";
	}

}