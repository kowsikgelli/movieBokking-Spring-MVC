package com.presidio.movieBooking.services;

import java.util.*;


import com.presidio.movieBooking.models.Movie;

public interface MovieService {
	List<Movie> getAllMovies();
	
	void saveMovie(Movie movie);
	void deleteMovieById(int id);
	Movie getMovieById(int id);
}
