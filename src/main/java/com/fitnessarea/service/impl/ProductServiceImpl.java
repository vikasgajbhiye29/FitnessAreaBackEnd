package com.fitnessarea.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnessarea.entity.Category;
import com.fitnessarea.entity.Product;
import com.fitnessarea.entity.User;
import com.fitnessarea.exception.ResourceNotFoundException;
import com.fitnessarea.repository.CategoryRepository;
import com.fitnessarea.repository.ProductRepository;
import com.fitnessarea.repository.UserRepository;
import com.fitnessarea.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository prepo;
	@Autowired
	private UserRepository urepo;
	@Autowired
	private CategoryRepository crepo;

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
	public Product updateProductById(Product product, int productID) {
		Product updateProduct = this.prepo.findById(productID).orElseThrow(
				() -> new ResourceNotFoundException("UPDATE_PRODUCT_ID : " + productID + " Invalid Or Not Found "));
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
	public void deleteProductById(int productID) {
		Product product = this.prepo.findById(productID).orElseThrow(
				() -> new ResourceNotFoundException("DELETE_PRODUCT_ID : " + productID + " Invalid Or Not Found "));
		this.prepo.delete(product);

	}

//	Getting a Product Details By Its ID
	@Override
	public Product getProductById(int productID) {
		Product product = this.prepo.findById(productID).orElseThrow(
				() -> new ResourceNotFoundException("PRODUCT_ID : " + productID + " Invalid Or Not Found "));
		return product;
	}

//	List Of All Products
	@Override
	public List<Product> listOfProduct() {
		List<Product> list = this.prepo.findAll();
		List<Product> listofproduct = list.stream().map(product -> product).collect(Collectors.toList());
		return listofproduct;
	}

//	Set User and Category By ID 
	@Override
	public Product setUserAndCatrgoryByIDInProduct(int productID, int userID, int categoryID) {
		Product findProduct = this.prepo.findById(productID).orElseThrow(
				() -> new ResourceNotFoundException("PRODUCT_ID : " + productID + " Invalid Or Not Found "));
		User findUser = this.urepo.findById(userID)
				.orElseThrow(() -> new ResourceNotFoundException("USER_ID : " + userID + " Invalid Or Not Found "));
		Category findCategory = this.crepo.findById(categoryID).orElseThrow(
				() -> new ResourceNotFoundException("CATEGORY_ID : " + categoryID + " Invalid Or Not Found "));
		findProduct.setProductCategory(findCategory);
		findProduct.setProductUser(findUser);
		Product save = this.prepo.save(findProduct);
		return save;
	}

}
