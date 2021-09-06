package com.presidio.movieBooking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.presidio.movieBooking.models.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository moviedata;

	@Override
	public List<Movie> getAllMovies() {
		return (List<Movie>) moviedata.findAll();
	}

	@Override
	public void saveMovie(Movie movie) {
		moviedata.save(movie);
	}

	@Override
	public void deleteMovieById(int id) {
		moviedata.deleteById(id);
	}

	@Override
	public Movie getMovieById(int id) {
		Movie movie=null;
		Optional<Movie> m =  moviedata.findById(id);
		if(m.isPresent()) {
			movie = m.get();
		}
		return movie;
	}

}
