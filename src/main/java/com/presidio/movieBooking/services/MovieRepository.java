package com.presidio.movieBooking.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.presidio.movieBooking.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
