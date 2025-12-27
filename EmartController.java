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

import com.quickEmart.demo.entity.Product;
import com.quickEmart.demo.entity.User;
import com.quickEmart.demo.service.DbServiceImpl;


@RestController
public class EmartController {
	
	@Autowired
	private DbServiceImpl dbService;
	
	@PostMapping(path = "/products/save" ,produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public String saveProduct(@RequestBody Product input) throws IOException{
     
		return this.dbService.createItem(input).toString();
		 
	}
	
	
	@GetMapping(path = "/products/getbyid/{id}" ,produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public Optional<Product> getProductById(@PathVariable Long id) throws IOException{
     
		return this.dbService.getItemById(id);
	}
	@GetMapping(path = "/products/getAllProducts" ,produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public List<Product> getAllProducts( ) throws IOException{
     
		return this.dbService.getAllProducts();
	}
	@GetMapping(path = "/products/getbyname/{name}" ,produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public Product getProductByName(@PathVariable String name) throws IOException{
     
		return this.dbService.getItemByname(name);
	}
	
	@GetMapping(path = "/products/deleteById/{id}" ,produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public void deleteItemById(@PathVariable Long id) throws IOException{
     
		 this.dbService.deleteItemById(id);
	}
	

}
