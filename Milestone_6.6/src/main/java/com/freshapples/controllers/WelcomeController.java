package com.freshapples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WelcomeController {

	@GetMapping("/")
	// Returns the home page.
	public String showHomePage(Model model){
		
		model.addAttribute("title", "Welcome");
		return "welcome";
		}
	}