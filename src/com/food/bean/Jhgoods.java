package com.food.bean;

import java.util.Date;

public class Jhgoods{
	private String jid;
	private int fid;
	private double jprice;
	private int jnum;
	private double jtotal;
	private Date jhdate;
	private String gysid;
	private Gys gys;
	private Food food;

	public String getJid() {
		return jid;
	}

	public void setJid(String jid) {
		this.jid = jid;
	}

	


	

	public double getJprice() {
		return jprice;
	}

	public void setJprice(double jprice) {
		this.jprice = jprice;
	}

	public int getJnum() {
		return jnum;
	}

	public void setJnum(int jnum) {
		this.jnum = jnum;
	}

	public double getJtotal() {
		return jtotal;
	}

	public void setJtotal(double jtotal) {
		this.jtotal = jtotal;
	}

	public Date getJhdate() {
		return jhdate;
	}

	public void setJhdate(Date jhdate) {
		this.jhdate = jhdate;
	}

	

	public String getGysid() {
		return gysid;
	}

	public void setGysid(String gysid) {
		this.gysid = gysid;
	}

	public Gys getGys() {
		return gys;
	}

	public void setGys(Gys gys) {
		this.gys = gys;
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

}
