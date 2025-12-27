package com.quickEmart.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.quickEmart.demo.entity.Orders;



public interface OrdersRepo extends CrudRepository<Orders,Long> {
	List<Orders>findAll();
  
}
