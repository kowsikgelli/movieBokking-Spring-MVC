package com.presidio.movieBooking.services;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.presidio.movieBooking.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
@Query(value="select * from User where email=?1",nativeQuery = true)
public User getUserByEmail(String email);

@Modifying
@Transactional
@Query(value="UPDATE User SET IS_LOGIN=true where email=?1",nativeQuery = true)
public void setLogin(String email);


@Query(value="select * from User where user_id =?1",nativeQuery = true)
public User getUserById(int id);

@Modifying
@Transactional
@Query(value="UPDATE User SET IS_LOGIN=false where USER_ID=?1",nativeQuery = true)
public void setLogout(int id);
}
