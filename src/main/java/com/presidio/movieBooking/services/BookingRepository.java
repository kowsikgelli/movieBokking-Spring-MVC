package com.presidio.movieBooking.services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.presidio.movieBooking.models.BookingCompositeKey;
import com.presidio.movieBooking.models.Bookings;

@Repository
public interface BookingRepository extends JpaRepository<Bookings,BookingCompositeKey>{
	

}
