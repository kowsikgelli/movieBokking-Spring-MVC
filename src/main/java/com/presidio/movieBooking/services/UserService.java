package com.presidio.movieBooking.services;

import java.util.List;

import com.presidio.movieBooking.models.User;

public interface UserService {
	List<User> getAllUsers();
	
	void saveUser(User user);
	void deleteUserById(int id);
	User getUserByEmail(String email);
	void setLogin(String email);
	void setLogout(int id);

	User getUserById(int id);
}
