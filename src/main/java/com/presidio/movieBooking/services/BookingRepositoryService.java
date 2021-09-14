package com.presidio.movieBooking.services;

import java.util.List;

import com.presidio.movieBooking.models.Bookings;

public interface BookingRepositoryService {
	public void saveBooking(Bookings booking);
	public List<Bookings> getAllUserBookings(int id);
	public void cancelBooking(int userId,int movie_no);
	public int getTotalNoOfTiketsBookedForAMovie(int id,String movieName);
	public double getTotalPriceForAUser(int id);
	public Bookings getBookingById(int user_id,int movie_no);
}
