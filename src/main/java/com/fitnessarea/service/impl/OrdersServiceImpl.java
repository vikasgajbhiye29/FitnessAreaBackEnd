package com.fitnessarea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnessarea.entity.Orders;
import com.fitnessarea.entity.Product;
import com.fitnessarea.exception.ResourceNotFoundException;
import com.fitnessarea.repository.OrdersRepository;
import com.fitnessarea.repository.ProductRepository;
import com.fitnessarea.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersRepository orderRepo;
	@Autowired
	private ProductRepository productRepo;

//	Create Order By Product ID
	@Override
	public Orders createOrderByProductID(Orders orders, int productID) {
		Product findProduct = this.productRepo.findById(productID).orElseThrow(
				() -> new ResourceNotFoundException("PRODUCT ID : " + productID + " Invalid Or Not Found "));
		Orders orderGenerate = new Orders();
		orderGenerate.setFinalPrice(findProduct.getProductPrice());
		orderGenerate.setQuantity(orders.getQuantity());
		orderGenerate.setDateOfPurchase(orders.getDateOfPurchase());
		orderGenerate.setDateOfDelivery(orders.getDateOfDelivery());
		orderGenerate.setOrderShifted(false);
		findProduct.setProductOrders(orderGenerate);
		Orders save = this.orderRepo.save(orderGenerate);
		return save;
	}

}
