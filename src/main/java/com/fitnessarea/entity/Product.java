package com.fitnessarea.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;
	@NotEmpty(message = "Enter Product Name")
	private String productName;
	@NotEmpty(message = "Enter Product Price")
	private long productPrice;
	@NotEmpty(message = "Enter Discount")
	private int productDiscount;
	private String productImage;
	@NotEmpty(message = "Add Product Description")
	private String productDescription;
//	Category Mapping
	@ManyToOne
	@JoinColumn(name = "categoryID")
	private Category productCategory;
//	User Mapping
	@ManyToOne
	@JoinColumn(name = "userID")
	private User productUser;
//	OrderMapping
	@ManyToOne
	@JoinColumn(name = "orderID")
	private Orders productOrders;

//	Setter And Getter
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	public User getProductUser() {
		return productUser;
	}

	public void setProductUser(User productUser) {
		this.productUser = productUser;
	}
	

	public Orders getProductOrders() {
		return productOrders;
	}

	public void setProductOrders(Orders productOrders) {
		this.productOrders = productOrders;
	}

	// ToString Method

	
	//	Constructors

}
