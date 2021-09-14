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
	
	@Query(value="SELECT SUM(NO_OF_TICKETS) from BOOKINGS WHERE USER_ID=?1 and MOVIE_NAME=?2",nativeQuery = true)
	public int getTotalNoOfTiketsBookedForAMovie(int id,String movieName);
	
	@Query(value="SELECT SUM(PRICE) from BOOKINGS WHERE USER_ID=?1",nativeQuery = true)
	public double getTotalPriceForAUser(int id);
	
	@Query(value="SELECT * FROM BOOKINGS WHERE USER_ID=?1 AND MOVIE_NO=?2",nativeQuery = true)
	public Bookings getBookingById(int user_id,int movie_no);
}
