package com.cg.dealsdateadminmicroservice.service;


import java.util.List;

import com.cg.dealsdateadminmicroservice.entity.OrderEntity;
import com.cg.dealsdateadminmicroservice.exception.OrderNotFoundException;
import com.cg.dealsdateadminmicroservice.model.OrderModel;



public interface IAdminService {
	
	 boolean deleteOrder(Integer orderId) throws OrderNotFoundException;
	OrderModel addOrder(OrderEntity order) throws OrderNotFoundException;
	List<OrderModel> displayListOfOrders();
	

    
}
