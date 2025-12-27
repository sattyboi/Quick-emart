package com.quickEmart.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickEmart.demo.entity.User;
import com.quickEmart.demo.repository.UserRepo;

@Service
public class LoginService {
	@Autowired
	private static final User NULL = null;
	@Autowired
    private UserRepo userRepo;

	public User checkLogin(String email, String password ) {
		
	try {
		if(password.equals(userRepo.findByemail(email).getPassword()))  
		{
			return userRepo.findByemail(email);
		}
		else {
			return  NULL;
		}
	}
	catch(Exception e){
		return  NULL;
	}
		
	}
	
}
