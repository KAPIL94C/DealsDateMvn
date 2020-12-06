package com.cg.dealsdateadminmicroservice.service;

import java.util.List;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.dealsdateadminmicroservice.dao.AdminDao;
import com.cg.dealsdateadminmicroservice.entity.OrderEntity;
import com.cg.dealsdateadminmicroservice.exception.OrderNotFoundException;
import com.cg.dealsdateadminmicroservice.model.OrderModel;




@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminDao adminDao;
    
    
	// converting model to entity
	public OrderEntity of(OrderModel source) {
		OrderEntity result = null;
		if (source != null) {
			result = new OrderEntity();
			result.setOrderId(source.getOrderId());
			result.setOrderQuantity(source.getOrderQuantity());
			result.setOrderStatus(source.getOrderStatus());
			result.setPaymentMethod(source.getPaymentMethod());
		}
		return result;
	}

	// converting entity to model
	// converting model to entity
	public OrderModel of(OrderEntity source) {
		OrderModel result = null;
		if (source != null) {
			result = new OrderModel();
			result.setOrderId(source.getOrderId());
			result.setOrderQuantity(source.getOrderQuantity());
			result.setOrderStatus(source.getOrderStatus());
			result.setPaymentMethod(source.getPaymentMethod());
		}
		return result;
	}
    
	
	/************************************************************************************
	 * Method: addOrder Description: To add the Order to Database
	 * 
	 * @param existById: check for the orderId if already exits
	 * @param save:      saves the order in the database
	 * @throws  
	 * @returns order: returns the order which is persisted
	 ************************************************************************************/

	// adding products to database
	@Override
	public OrderModel addOrder(OrderEntity order) throws OrderNotFoundException {
		if (order == null) {
			throw new OrderNotFoundException("order Should not be null");
		}
		if (adminDao.existsById(order.getOrderId())) {

			throw new OrderNotFoundException("This order already exist !");
		}
		return of(adminDao.save(order));

	}
	
   
	/*********************************************************************************************
	 * Method: displayOrders Description: display all orders details from
	 * the table
	 * 
	 * @param findAll: fetches complete list of orders
	 * @returns List<OrderModel>: returns the list of orders
	 *********************************************************************************************/

	// display all orders details from the table
	@Override
	public List<OrderModel> displayListOfOrders() {
		return adminDao.findAll().stream().map(entity -> of(entity)).collect(Collectors.toList());
	}

	
  

	
	/**********************************************************************************************************************
	 * Method: deleteOrder Description: deleting a order by Id
	 * 
	 * @param findById: fetches orders based on particular orderId
	 * @param delete:   deletes orders based on particular order Id
	 ***********************************************************************************************************************/
	// deleting a order
	@Override
	public boolean deleteOrder(Integer id) throws OrderNotFoundException {
		boolean flag = false;
		if (id == null) {
			throw new OrderNotFoundException("order id should not be null");
		}
		else {
			adminDao.deleteById(id);
			flag = true;
		}
		return flag;
	}

	

	
	}

 

