package com.quickEmart.demo.service;

import java.util.List;
import java.util.Optional;

import com.quickEmart.demo.entity.User;

public interface UserDbService {

	User createUser(User newUser);
	 Optional<User> getUserById(Long id);
	 User getItemByemail(String email);
//	 
	
	List<User> getAllUsers();
	
//	void deleteUserByName(String first_name);
	void deleteUserById(Long id);
//	User getItemByName(String first_name);
//	User getItemByName(String first_name);
//	void deleteUserByName(String first_name);
}
