package com.presidio.movieBooking.services;

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

}
