package com.freshapples.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.freshapples.model.*;

import com.freshapples.services.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	// Display list.
	@GetMapping("/orders2")
	public String viewOrdersPage(Model model){
		model.addAttribute("listMovies", movieService.getAllMovies());
		return "orders2.html";
	}
	@GetMapping("/showNewMovieForm")
	public String showNewMovieForm(Model model){
		// Bind the form data.
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "new_movie";
	}
	
	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("movie") Movie movie){
		// Save movie to the SQL database.
		movieService.saveMovie(movie);
		return "redirect:/orders2";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
		Movie movie = movieService.getMovieById(id);
		
		model.addAttribute("movie", movie);
		return "update_movie";		
	}
	
	@GetMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable (value = "id") long id){
		this.movieService.deleteMovieById(id);
		return "redirect:/orders2";
	}
	
}