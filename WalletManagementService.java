package com.quickEmart.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickEmart.demo.entity.User;
import com.quickEmart.demo.repository.UserRepo;
@Service
public class WalletManagementService {
	@Autowired
	private UserRepo repo1;
	
	public void UpdateMoney(Long user_id,Float amt) {
		
		User user ;
		
	  user= repo1.findById(user_id).get();
	  
	  Float y= user.getWallet();
	 user.setWallet(y+amt);
	 repo1.save(user);
	  
	 
		
		
	}

}
