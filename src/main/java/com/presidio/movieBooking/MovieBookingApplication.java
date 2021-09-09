package com.presidio.movieBooking;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.presidio.movieBooking.controllers.MovieController;

@SpringBootApplication
public class MovieBookingApplication {

	public static void main(String[] args) {
		
		new File(MovieController.uploadDirectory).mkdir();
		SpringApplication.run(MovieBookingApplication.class, args);
	}

}
