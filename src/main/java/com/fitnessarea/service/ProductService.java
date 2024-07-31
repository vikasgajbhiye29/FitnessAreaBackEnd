package com.fitnessarea.service;

import java.util.List;
import com.fitnessarea.entity.Product;

public interface ProductService {
//	Create Product
	Product createProduct(Product product);
//	Update Product By Its ID
	Product updateProductById(Product product, int pid);
//	Delete Product By Its ID
	void deleteProductById(int pid);
//	Getting a Product Details By Its ID
	Product getProductById(int pid);
//	List Of All Products
	List<Product> listOfProduct();
	
	
}
	