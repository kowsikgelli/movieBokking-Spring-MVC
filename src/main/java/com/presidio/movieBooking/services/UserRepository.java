package com.presidio.movieBooking.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.presidio.movieBooking.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
