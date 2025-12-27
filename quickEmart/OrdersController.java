package com.quickEmart.demo.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.quickEmart.demo.entity.ItemList;
import com.quickEmart.demo.entity.Orders;
import com.quickEmart.demo.service.CartService;
import com.quickEmart.demo.service.OrdersDbServiceImpl;


@RestController
public class OrdersController {
	
	@Autowired
	private OrdersDbServiceImpl ordersdbService;
	@Autowired
	private CartService cartService;
	
	@PostMapping(path = "/orders/save" ,produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public void saveOrder(@RequestBody Orders input) throws IOException{
     
		 this.ordersdbService.createOrder(input.getUser_id(),input.getProduct_id(),input.getProduct_qty());
		 
	}
	@PostMapping(path = "/orders/sendCart" ,produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public void sendCart(@RequestBody ItemList list) throws IOException{
		
		Long user_id = list.getUserId();
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		cartService.addToCart(user_id, gson.toJson(list));
		
     
		 
		 
	}

	@GetMapping(path = "/orders/getCart/{user_id}" ,produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public String getCart(@PathVariable Long user_id) throws IOException, ClassNotFoundException{
     
		
	  return cartService.fetchFromCart(user_id);
	}
	
	@GetMapping(path = "/orders/getbyid/{id}" ,produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public Optional<Orders> getProductById(@PathVariable Long id) throws IOException{
     
		return this.ordersdbService.getItemById(id);
	}
}
