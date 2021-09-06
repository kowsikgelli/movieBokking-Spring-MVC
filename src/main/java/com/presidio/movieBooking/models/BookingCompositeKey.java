package com.presidio.movieBooking.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class BookingCompositeKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int movie_no;
	private int userId;
	public int getMovie_no() {
		return movie_no;
	}
	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}
	public BookingCompositeKey() {
		
	}
	public BookingCompositeKey(int movie_no, int userId) {
		super();
		this.movie_no = movie_no;
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(movie_no, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingCompositeKey other = (BookingCompositeKey) obj;
		return movie_no == other.movie_no && userId == other.userId;
	}
}
