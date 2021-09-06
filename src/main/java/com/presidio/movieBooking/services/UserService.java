package com.presidio.movieBooking.services;

import java.util.List;

import com.presidio.movieBooking.models.User;

public interface UserService {
	List<User> getAllUsers();
	
	void saveUser(User user);
	void deleteUserById(String email);
	User getUserById(String email);
}
