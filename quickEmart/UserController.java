package com.quickEmart.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.quickEmart.demo.entity.User;
import com.quickEmart.demo.service.LoginService;
import com.quickEmart.demo.service.UserDbServiceImpl;
import com.quickEmart.demo.service.WalletManagementService;

@RestController
public class UserController {
	@Autowired
	private UserDbServiceImpl userdbService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private WalletManagementService wallet;
	
	@PostMapping(path = "/users/save" ,produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public String saveUser(@RequestBody User input) throws IOException{
     
		return this.userdbService.createUser(input).toString();
		 
	}
	
	@GetMapping(path = "/users/getbyid/{id}" ,produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public Optional<User> getUserById(@PathVariable Long id) throws IOException{
	     
		return this.userdbService.getUserById(id);
	}
	@GetMapping(path = "/users/deleteById/{id}" ,produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public void deleteUserById(@PathVariable Long id) throws IOException{
     
		 this.userdbService.deleteUserById(id);
	}
	@GetMapping(path = "/users/getAll" ,produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public List<User> getAll( ) throws IOException{
     
		return this.userdbService.getAllUsers();
	}
	
//	@GetMapping(path = "/users//{first_name}" ,produces= MediaType.APPLICATION_JSON_VALUE)
//	@CrossOrigin(origins = "http://127.0.0.1:5500/")
//	public void deleteUserByName(@PathVariable String first_name) throws IOException{
//     
//		 this.userdbService.deleteUserByName(first_name);
//	}
	@PostMapping(path= "/login",produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public User checkLogin(@RequestBody User user) {
		 
	  return this.loginService.checkLogin(user.getEmail(),user.getPassword());
		
	}
	
	@PostMapping(path= "/wallet/update/{user_id}/{amt}",produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public void updateWallet(@PathVariable Long user_id, @PathVariable Float amt) {
		
		
		wallet.UpdateMoney(user_id, amt);
		
		
		
		 
	  
		
	}
	
	
	

}
