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
	@Override
	public Product createProduct(Product product) {
		Product createProduct = new Product();
		createProduct.setPname(product.getPname());
		createProduct.setPprice(product.getPprice());
		createProduct.setPdesc(product.getPdesc());
		createProduct.setPcat(product.getPcat());
		Product saveProduct = this.prepo.save(createProduct);
		return saveProduct;
	}

	@Override
	public Product updateProductById(Product product, int pid) {
		Product updateProduct = this.prepo.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Product ID : " + pid + "Invalid Product ID For Updation"));
		updateProduct.setPname(product.getPname());
		updateProduct.setPprice(product.getPprice());
		updateProduct.setPdesc(product.getPdesc());
		updateProduct.setPcat(product.getPcat());
		Product update = this.prepo.save(updateProduct);
		return update;
	}

	@Override
	public void deleteProductById(int pid) {
		Product product = this.prepo.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Product ID : " + pid + "Invalid Product ID For Deletion"));
		this.prepo.delete(product);
		
		
	}

	@Override
	public Product getProductById(int pid) {
		Product product = this.prepo.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Product ID : " + pid + "Invalid Product ID"));
		return product;
	}

	@Override
	public List<Product> listOfProduct() {
		List<Product> list = this.prepo.findAll();
		List<Product> listofproduct = list.stream().map(product -> product).collect(Collectors.toList());
		return listofproduct;
	}

}
