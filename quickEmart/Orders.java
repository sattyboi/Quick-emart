package com.quickEmart.demo.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders") 
public class Orders {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long order_id;
	private Long user_id;
	private Long product_id;
	private int product_qty;
	private float product_price;
 
	private float totalprice;
	private LocalDateTime orderTime;
	
	
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalDateTime localDateTime) {
		this.orderTime = localDateTime;
	}
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public int getProduct_qty() {
		return product_qty;
	}
	public void setProduct_qty(int product_qty) {
		this.product_qty = product_qty;
	}
	public float getProduct_price() {
		return product_price;
	}
	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}
	
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalPrice) {
		this.totalprice = totalPrice;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	

}
