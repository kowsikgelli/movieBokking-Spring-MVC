package com.presidio.movieBooking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int movie_no;
	public String movieName;
	public String author;
	public String description;
	public String moviePhotoName;
	public String trailerLink;
	public int noOfTicketsAvailable;
	public int getNoOfTicketsAvailable() {
		return noOfTicketsAvailable;
	}
	public void setNoOfTicketsAvailable(int noOfTicketsAvailable) {
		this.noOfTicketsAvailable = noOfTicketsAvailable;
	}
	public int getNoOfTicketsBooked() {
		return noOfTicketsBooked;
	}
	public void setNoOfTicketsBooked(int noOfTicketsBooked) {
		this.noOfTicketsBooked = noOfTicketsBooked;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int noOfTicketsBooked;
	public double price;
	public String getTrailerLink() {
		return trailerLink;
	}
	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
	}
	public String getMoviePhotoName() {
		return moviePhotoName;
	}
	public void setMoviePhotoName(String moviePhotoName) {
		this.moviePhotoName = moviePhotoName;
	}
	public int getMovie_no() {
		return movie_no;
	}
	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
