package com.food.bean;

import java.io.Serializable;

public class Food implements Serializable{
  private int fid;
  private String fname;
  private double f_price;
  private int did;
  private String image;
  private String batch;
  private int num;
public String getBatch() {
	return batch;
}
public void setBatch(String batch) {
	this.batch = batch;
}
public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public double getF_price() {
	return f_price;
}
public void setF_price(double f_price) {
	this.f_price = f_price;
}
public int getDid() {
	return did;
}
public void setDid(int did) {
	this.did = did;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
  
}
