package com.quickEmart.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.quickEmart.demo.entity.Product;
 @Repository
public interface ProductRepo extends CrudRepository<Product,Long>{

	List<Product>findAll();
	
	Product findByName(String name);
	
	
}
