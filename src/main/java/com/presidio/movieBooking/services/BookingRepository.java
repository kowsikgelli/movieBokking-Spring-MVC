package com.presidio.movieBooking.services;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.presidio.movieBooking.models.BookingCompositeKey;
import com.presidio.movieBooking.models.Bookings;

@Repository
public interface BookingRepository extends JpaRepository<Bookings,BookingCompositeKey>{
	
	@Query(value="select * from BOOKINGS where USER_ID=?1",nativeQuery = true)
	public List<Bookings> getAllUserBookings(int id);
	
	@Modifying
	@Transactional
	@Query(value="DELETE from BOOKINGS where USER_ID=?1 AND MOVIE_NO=?2",nativeQuery = true)
	public void cancelBooking(int userId,int movie_no);
}
