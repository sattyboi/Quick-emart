package com.quickEmart.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickEmart.demo.entity.Orders;
import com.quickEmart.demo.repository.OrdersRepo;
import com.quickEmart.demo.repository.ProductRepo;
import com.quickEmart.demo.repository.UserRepo;

@Service
public class OrdersDbServiceImpl implements OrdersDbService {

	 @Autowired
	private final ProductRepo productRepo ;
	 @Autowired
	private final OrdersRepo ordersRepo;
	 @Autowired
	 private DbServiceImpl pdtDb;
	 @Autowired
	 private WalletManagementService wallet;
	
	public OrdersDbServiceImpl(ProductRepo productRepo,OrdersRepo ordersRepo) {
		this.ordersRepo= ordersRepo;
		this.productRepo= productRepo;
		
	}
	@Override
	public void createOrder(Long user_id, long product_id, int product_qty) {
		float totalPrice= product_qty*productRepo.findById(product_id).get().getPrice();
		
		Orders order = new Orders();
		order.setUser_id(user_id);
		order.setProduct_id(product_id);
		order.setProduct_qty(product_qty);
		order.setTotalprice(totalPrice);
		order.setOrderTime(LocalDateTime.now());
		order.setProduct_price(productRepo.findById(product_id).get().getPrice());
		pdtDb.reduceQty(product_qty, product_id);
		
		ordersRepo.save(order);
		wallet.UpdateMoney(user_id, -totalPrice);
		
		
		
	}
	@Override
	public Optional<Orders> getItemById(Long order_id) {
		// TODO Auto-generated method stub
		return ordersRepo.findById(order_id);
	}
	
	
	

}
