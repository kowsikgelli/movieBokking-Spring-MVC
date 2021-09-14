package com.presidio.movieBooking.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bookings {
	
	@Id
	@EmbeddedId
	private BookingCompositeKey id; 
	
	private int noOfTickets;
	private String movieName;
	private double price;

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Bookings() {
		
	}
	public Bookings(BookingCompositeKey id, int noOfTickets,String movieName,double price) {
		super();
		this.id = id;
		this.noOfTickets = noOfTickets;
		this.movieName = movieName;
		this.price = price;
	}

	public BookingCompositeKey getId() {
		return id;
	}

	public void setId(BookingCompositeKey id) {
		this.id = id;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	
	
}
 