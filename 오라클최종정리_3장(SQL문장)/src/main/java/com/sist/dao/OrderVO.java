package com.sist.dao;

import java.util.Date;

import javax.xml.crypto.Data;

public class OrderVO {
	private int orderid, custid, bookid, saleprice;
	private java.util.Date orderdate;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}
	public Data getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date date) {
		this.orderdate = date;
	}
	
	
}
