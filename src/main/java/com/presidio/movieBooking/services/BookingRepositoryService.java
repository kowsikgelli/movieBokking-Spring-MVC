package com.presidio.movieBooking.services;

import java.util.List;

import com.presidio.movieBooking.models.Bookings;

public interface BookingRepositoryService {
	public void saveBooking(Bookings booking);
	public List<Bookings> getAllUserBookings(int id);
	public void cancelBooking(int userId,int movie_no);
}
