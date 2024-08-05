package com.fitnessarea.service;

import com.fitnessarea.entity.Orders;

public interface OrdersService {
//	Create Order By productID
	Orders createOrderByProductID(Orders orders, int productID);
}
