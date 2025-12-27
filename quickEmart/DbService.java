package com.quickEmart.demo.service;

import java.util.List;
import java.util.Optional;

import com.quickEmart.demo.entity.Product;

public interface DbService {
	
	Product createItem(Product newItem);
	 Optional<Product> getItemById(Long id);
	 Product getItemByname(String name);
	 
	 void deleteItemById(Long id);
	List<Product> getAllProducts();
	
	
		
	

}
