package com.presidio.movieBooking.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Bookings {

	@EmbeddedId
	private BookingCompositeKey id; 
	
	private int noOfTickets;

	public Bookings() {
		
	}
	public Bookings(BookingCompositeKey id, int noOfTickets) {
		super();
		this.id = id;
		this.noOfTickets = noOfTickets;
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
 