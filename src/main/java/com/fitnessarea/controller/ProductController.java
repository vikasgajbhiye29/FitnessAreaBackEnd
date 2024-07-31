package com.fitnessarea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fitnessarea.entity.Product;
import com.fitnessarea.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
//	Create Product URL:- http://localhost:8080/cp
	@PostMapping("/cp")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product product1 = this.productService.createProduct(product);
		return new ResponseEntity<Product>(product1, HttpStatus.CREATED);
	}
//	Update Product By Its ID URL:- http://localhost:8080/up/enterid
	@PutMapping("/up/{pid}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable int pid){
		Product update = this.productService.updateProductById(product, pid);
		return new ResponseEntity<Product> (update, HttpStatus.OK);
	}
//	Delete Product By Its ID URL:- http://localhost:8080/dp/enterid
	@DeleteMapping("/dp/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable int pid){
		this.productService.deleteProductById(pid);
		return new ResponseEntity<String>("Delete Product Successfully",HttpStatus.OK);			
	}
//	Getting a Single Product Details By Its ID URL:- http://localhost:8080/sp/enterid
	@GetMapping("/sp/{pid}")
	public ResponseEntity<Product> getSingleProduct(@PathVariable int pid){
		Product product = this.productService.getProductById(pid);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
//	List Of Product URL:- http://localhost:8080/pl
	@GetMapping("/pl")
	public ResponseEntity<List<Product>> productList(){
		List<Product> list = this.productService.listOfProduct();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
}