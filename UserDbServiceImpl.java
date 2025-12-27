package com.quickEmart.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickEmart.demo.entity.Product;
import com.quickEmart.demo.entity.User;
import com.quickEmart.demo.repository.UserRepo;

@Service
public class UserDbServiceImpl implements UserDbService{
	 @Autowired
	 private UserRepo repo;
	
 
    



	@Override
	public List<User> getAllUsers() {
		Iterable<User> itr=repo.findAll();
		List<User> userList = new ArrayList<User>();
		for(User it:itr) {
			userList.add(it);
		}
	return userList;
	}






	@Override
	public User createUser(User newUser) {
		 if(newUser.getRole() == null)
		 {
			 newUser.setRole("Customer");
			 newUser.setWallet((float) 1000);
		 }
		return repo.save(newUser);
	}






	@Override
	public Optional<User> getUserById(Long id) {
		
		return repo.findById(id);
	}






	
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}






	@Override
	public User getItemByemail(String email) {
		
		return repo.findByemail(email);
	
	}
	
	

//	@Override
//	public User getItemByName(String first_name) {
//		
//		return repo.findByfirst_name(first_name);
//	
//	}

//	public void deleteUserByName(String first_name) {
//		
//		User user = repo.findByfirst_name(first_name);
//		repo.delete(user);
//		
//	}






	
	
}
