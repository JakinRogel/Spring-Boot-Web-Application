package com.freshapples.services;

import java.util.List;

import com.freshapples.model.Movie;

public interface MovieService {
	List<Movie> getAllMovies();
	void saveMovie(Movie movie);
	Movie getMovieById(long id);
	void deleteMovieById(long id);
}