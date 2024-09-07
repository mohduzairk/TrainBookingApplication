package com.trainbookingapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainbookingapplication.model.User;


public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);

}
