package com.presidio.movieBooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.presidio.movieBooking.models.Bookings;

@Service
public class BookingServiceImpl implements BookingRepositoryService {
	
	@Autowired
	private BookingRepository bookingdata;

	@Override
	public void saveBooking(Bookings booking) {
		bookingdata.save(booking);
	}

	@Override
	public List<Bookings> getAllUserBookings(int id) {
		return bookingdata.getAllUserBookings(id);
	}

	@Override
	public void cancelBooking(int userId, int movie_no) {
		bookingdata.cancelBooking(userId, movie_no);
	}

	@Override
	public int getTotalNoOfTiketsBookedForAMovie(int id, String movieName) {
		return bookingdata.getTotalNoOfTiketsBookedForAMovie(id, movieName);
	}

	@Override
	public double getTotalPriceForAUser(int id) {
		return bookingdata.getTotalPriceForAUser(id);
	}

	@Override
	public Bookings getBookingById(int user_id, int movie_no) {
		return bookingdata.getBookingById(user_id, movie_no);
	}

}
