package com.fitnessarea.service.impl;
 
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fitnessarea.entity.Product;
import com.fitnessarea.exception.ResourceNotFoundException;
import com.fitnessarea.repository.ProductRepository;
import com.fitnessarea.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository prepo;

//	Create Product
	@Override
	public Product createProduct(Product product) {
		Product createProduct = new Product();
		createProduct.setProductName(product.getProductName());
		createProduct.setProductPrice(product.getProductPrice());
		createProduct.setProductDiscount(product.getProductDiscount());
		createProduct.setProductImage(product.getProductImage());
		createProduct.setProductDescription(product.getProductDescription());
		Product saveProduct = this.prepo.save(createProduct);
		return saveProduct;
	}

//	Update Product By Its ID
	@Override
	public Product updateProductById(Product product, int pid) {
		Product updateProduct = this.prepo.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Product ID : " + pid + "Invalid Product ID For Updation"));
		updateProduct.setProductName(product.getProductName());
		updateProduct.setProductPrice(product.getProductPrice());
		updateProduct.setProductDiscount(product.getProductDiscount());
		updateProduct.setProductImage(product.getProductImage());
		updateProduct.setProductDescription(product.getProductDescription());
		Product update = this.prepo.save(updateProduct);
		return update;
	}

//	Delete Product By Its ID
	@Override
	public void deleteProductById(int pid) {
		Product product = this.prepo.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Product ID : " + pid + "Invalid Product ID For Deletion"));
		this.prepo.delete(product);
		
		
	}

//	Getting a Product Details By Its ID
	@Override
	public Product getProductById(int pid) {
		Product product = this.prepo.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Product ID : " + pid + "Invalid Product ID"));
		return product;
	}

//	List Of All Products
	@Override
	public List<Product> listOfProduct() {
		List<Product> list = this.prepo.findAll();
		List<Product> listofproduct = list.stream().map(product -> product).collect(Collectors.toList());
		return listofproduct;
	}


}
