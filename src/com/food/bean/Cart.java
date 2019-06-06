package com.food.bean;

import java.util.HashMap;


public class Cart {
 private HashMap<Integer,CartItem> cartItems=new HashMap<Integer,CartItem>();
	 
	 private double total;



	public HashMap<Integer, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(HashMap<Integer, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	 
}
