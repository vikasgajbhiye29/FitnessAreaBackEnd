package com.fitnessarea.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity

public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderID;
	private String orderShifted;
	private String clientName;
	private String productName;
	private int quantity;
	private long price;
	private Date dateOfPurchase;
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getOrderShifted() {
		return orderShifted;
	}
	public void setOrderShifted(String orderShifted) {
		this.orderShifted = orderShifted;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", orderShifted=" + orderShifted + ", clientName=" + clientName
				+ ", productName=" + productName + ", quantity=" + quantity + ", price=" + price + ", dateOfPurchase="
				+ dateOfPurchase + "]";
	}
	public Orders() {
		super();
	}
	public Orders(int orderID, String orderShifted, String clientName, String productName, int quantity, long price,
			Date dateOfPurchase) {
		super();
		this.orderID = orderID;
		this.orderShifted = orderShifted;
		this.clientName = clientName;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.dateOfPurchase = dateOfPurchase;
	}
	
	
	
	
	
}

