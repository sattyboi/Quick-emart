package com.quickEmart.demo.service;



import java.util.Optional;

import com.quickEmart.demo.entity.Orders;



public interface OrdersDbService {
	
	void createOrder(Long user_id, long product_id, int product_qty);
	public Optional<Orders> getItemById(Long order_id);
}
