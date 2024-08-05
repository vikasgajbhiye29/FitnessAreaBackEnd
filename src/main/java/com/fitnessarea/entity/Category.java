package com.fitnessarea.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryID;
	@NotEmpty(message = "Enter Category Name")
	private String categoryName;

//	Product Mapping
	@JsonIgnore
	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> categoryProduct = new ArrayList<>();

//	Setter And Getter
	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(List<Product> categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

//	ToString Method
	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryName=" + categoryName + ", categoryProduct="
				+ categoryProduct + "]";
	}

//	Constructors

}
