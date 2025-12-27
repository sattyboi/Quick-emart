package com.quickEmart.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.quickEmart.demo.entity.User;

public interface UserRepo extends CrudRepository<User,Long> {

//	List<User>findAll();
	
	User findByemail(String email);
//	User deleteByName(String first_name);

//	void deleteByName(String first_name);

//
//
//   User findByfirst_name(String first_name);


}
