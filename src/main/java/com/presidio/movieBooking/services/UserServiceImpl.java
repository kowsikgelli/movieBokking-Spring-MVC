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
	public void deleteUserById(int id) {
		userdata.deleteById(id);
	}

	@Override
	public User getUserByEmail(String email) {
		return userdata.getUserByEmail(email);
	}
	
	@Override
	public User getUserById(int id) {
		return userdata.getUserById(id);
	}


	@Override
	public void setLogin(String email) {
		userdata.setLogin(email);
	}

	@Override
	public void setLogout(int id) {
		userdata.setLogout(id);		
	}
	

}
