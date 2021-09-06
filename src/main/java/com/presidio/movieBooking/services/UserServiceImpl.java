package com.presidio.movieBooking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.presidio.movieBooking.models.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userdata;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userdata.findAll();
	}

	@Override
	public void saveUser(User user) {
		userdata.save(user);

	}

	@Override
	public void deleteUserById(String email) {
		userdata.deleteById(email);
	}

	@Override
	public User getUserById(String email) {
		User user = null;
		Optional<User> u = userdata.findById(email);
		if(u.isPresent()) {
			user = u.get();
		}
		return user;
	}
	

}
