package com.quickEmart.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
	
	Long userId;
	List<ItemUnit> itemList= new ArrayList<ItemUnit>();
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<ItemUnit> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemUnit> itemList) {
		this.itemList = itemList;
	}
	

}
