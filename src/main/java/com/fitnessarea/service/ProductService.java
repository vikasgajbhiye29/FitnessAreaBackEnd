package com.fitnessarea.service;

import java.util.List;

import com.fitnessarea.entity.Product;

public interface ProductService {
	
	Product createProduct(Product product);
	
	Product updateProductById(Product product, int pid);
	
	void deleteProductById(int pid);
	
	Product getProductById(int pid);
	
	List<Product> listOfProduct();
	
	
}
	