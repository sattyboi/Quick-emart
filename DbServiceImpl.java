package com.quickEmart.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.quickEmart.demo.entity.Product;
import com.quickEmart.demo.repository.ProductRepo;

@Service
public class DbServiceImpl implements DbService {
	 @Autowired
	private ProductRepo repo;
	   
	
		 
		 
	

	@Override
	public Product createItem(Product newItem) {
		
		return repo.save(newItem);
	}
	
	

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}



	@Override
	public Optional<Product> getItemById(Long id) {
		
		return repo.findById(id);
	}
	


	@Override
	public Product getItemByname(String name) {
		
		return repo.findByName(name);
		
	}



	public void deleteItemById(Long id) {
		
		 repo.deleteById(id);
	}


	public void reduceQty(int product_qty, Long product_id) throws NullPointerException {
		
		int y = repo.findById(product_id).get().getQuantity();
//		 repo.findById(product_id).get().setQuantity(y - product_qty);
		Product temp = repo.findById(product_id).get();
		temp.setQuantity(y-product_qty);
		repo.save(temp);
		
		
	
		
	}
	

}
