package com.fitnessarea.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderID;
	private int quantity;
	private long finalPrice;
	private Date dateOfPurchase;
	private Date dateOfDelivery;
	private Boolean orderShifted;
	
	@JsonIgnore
	@OneToMany(mappedBy = "productOrders", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> productID = new ArrayList<>();

//	Setter and Getter
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(long finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}

	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}

	public Boolean getOrderShifted() {
		return orderShifted;
	}

	public void setOrderShifted(Boolean orderShifted) {
		this.orderShifted = orderShifted;
	}

	public List<Product> getProductID() {
		return productID;
	}

	public void setProductID(List<Product> productID) {
		this.productID = productID;
	}
	

	

	
	
	
	
	
}

