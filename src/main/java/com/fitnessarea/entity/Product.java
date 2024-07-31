package com.fitnessarea.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;
	private String productName;
	private long productPrice;
	private int productDiscount;
	private String productImage;
	private String productDescription;
//	Category Mapping
	@ManyToOne
	@JoinColumn(name = "categoryID")
	private Category productCategory;
//	User Mapping
	@ManyToOne
	@JoinColumn(name = "userID")
	private User productUser;

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

	//	ToString Method
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDiscount=" + productDiscount + ", productImage=" + productImage + ", productDescription="
				+ productDescription + ", productCategory=" + productCategory + "]";
	}

//	Constructors
	public Product() {
		super();
	}

	public Product(int productID, String productName, long productPrice, int productDiscount, String productImage,
			String productDescription, Category productCategory) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productImage = productImage;
		this.productDescription = productDescription;
		this.productCategory = productCategory;
	}


	
	
	
	
	
	
	
	
	
}
