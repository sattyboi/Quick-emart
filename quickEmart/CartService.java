package com.quickEmart.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickEmart.demo.entity.User;
import com.quickEmart.demo.repository.UserRepo;

@Service
public class CartService {
	
 @Autowired
 private UserRepo userRepo;
 
  public void addToCart(Long user_id,String cartList) {
	  
	  User user = userRepo.findById(user_id).get();
	  user.setItemList(cartList);
	 userRepo.save(user);
	  
	  
  }
  
  public String fetchFromCart(Long user_id) {
	  
	  User user = userRepo.findById(user_id).get();
	  return user.getItemList();
	  
  }
 
 

}
