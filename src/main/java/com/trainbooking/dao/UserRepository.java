package com.trainbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainbooking.model.User;


public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);

}
