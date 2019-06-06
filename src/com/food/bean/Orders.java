package com.food.bean;

import java.util.ArrayList;
import java.util.Date;

public class Orders {
   private String oid;
   private Date ordertime;
   private Double total;
   private int state;
   private String address;
   private String name;
   private String telephone;
   private int uid;
   private ArrayList<OrderItem> items;

public String getOid() {
	return oid;
}
public void setOid(String oid) {
	this.oid = oid;
}
public Date getOrdertime() {
	return ordertime;
}
public void setOrdertime(Date ordertime) {
	this.ordertime = ordertime;
}
public Double getTotal() {
	return total;
}
public void setTotal(Double total) {
	this.total = total;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public ArrayList<OrderItem> getItems() {
	return items;
}
public void setItems(ArrayList<OrderItem> items) {
	this.items = items;
}
   
}
