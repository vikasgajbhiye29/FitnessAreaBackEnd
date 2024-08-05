package com.fitnessarea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fitnessarea.entity.Orders;
import com.fitnessarea.service.OrdersService;

@RestController
public class OrderController {
	@Autowired
	private OrdersService ordersService;

//	Create Order By Product ID
//	URL:- http://localhost/8080/cobpID/productID
	@PostMapping("/cobpID/{productID}")
	public ResponseEntity<Orders> createOrderByProductID(@RequestBody Orders order, @PathVariable int productID) {
		Orders createOrder = this.ordersService.createOrderByProductID(order, productID);
		return new ResponseEntity<Orders>(createOrder, HttpStatus.OK);
	}

}
