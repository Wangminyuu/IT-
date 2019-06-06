package com.food.bean;
public class OrderItem {
	private int itemid;
	
	private int count;
	
	private double subtotal;
	
	private int fid;	
	private Food food;
	private String oid;
	
	private int allHotCount;
	
	
	public int getAllHotCount() {
		return allHotCount;
	}

	public void setAllHotCount(int allHotCount) {
		this.allHotCount = allHotCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	
}
