package com.fitnessarea.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Shopping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shoppingID;
	private String product;
	private int productID;
	private long cost;
	private String category;
	private String image;
	private String description;
	public int getShoppingID() {
		return shoppingID;
	}
	public void setShoppingID(int shoppingID) {
		this.shoppingID = shoppingID;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Shopping [shoppingID=" + shoppingID + ", product=" + product + ", productID=" + productID + ", cost="
				+ cost + ", category=" + category + ", image=" + image + ", description=" + description + "]";
	}
	public Shopping() {
		super();
	}
	public Shopping(int shoppingID, String product, int productID, long cost, String category, String image,
			String description) {
		super();
		this.shoppingID = shoppingID;
		this.product = product;
		this.productID = productID;
		this.cost = cost;
		this.category = category;
		this.image = image;
		this.description = description;
	}
	
	
}
