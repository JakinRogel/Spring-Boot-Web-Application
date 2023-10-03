package com.freshapples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	@GetMapping("/home")
	// Returns the home page.
	public String showHomePage(Model model){
		
		model.addAttribute("title", "My Home");
		return "home";
		}
	}