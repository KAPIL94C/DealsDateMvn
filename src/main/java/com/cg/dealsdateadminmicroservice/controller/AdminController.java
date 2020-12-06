package com.cg.dealsdateadminmicroservice.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cg.dealsdateadminmicroservice.entity.OrderEntity;
import com.cg.dealsdateadminmicroservice.exception.OrderNotFoundException;
import com.cg.dealsdateadminmicroservice.exception.ProductNotFoundException;
import com.cg.dealsdateadminmicroservice.model.OrderModel;
import com.cg.dealsdateadminmicroservice.model.ProductModel;
import com.cg.dealsdateadminmicroservice.service.IAdminService;
import com.cg.dealsdateadminmicroservice.service.IProductService;



/*
@author  TRIPATHI
*/
@RestController
@RequestMapping("/adminController")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@Autowired
	private IProductService service;
	
	@Autowired
    private IAdminService adminService;

	// display list of all products
	@GetMapping("/listofproducts")
	public ResponseEntity<List<ProductModel>> getListOfProducts() {
		ResponseEntity<List<ProductModel>> response = null;
		List<ProductModel> product = service.displayListOfProducts();
		if (product == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(product, HttpStatus.OK);
		}
		return response;

	}


	/**********************************************************************************************************************
	 * Method: deleteProduct Description: deleting a product by Id
	 * 
	 * @param deleteProduct: deletes products based on particular product Id
	 * @returns product: returns the boolean response entity
	 ***********************************************************************************************************************/
	// deleting a product
	@DeleteMapping("/deleteproducts/{id}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable(value = "id") Integer id)
			throws ProductNotFoundException {
		boolean value = service.deleteProduct(id);
		if (value == true)
			return ResponseEntity.ok(true);
		else
			return ResponseEntity.ok(false);
	}
	
	// display list of all orders
		@GetMapping("/listoforders")
		public ResponseEntity<List<OrderModel>> getListOfOrders() {
			ResponseEntity<List<OrderModel>> response = null;
			List<OrderModel> order = adminService.displayListOfOrders();
			if (order == null) {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				response = new ResponseEntity<>(order, HttpStatus.OK);
			}
			return response;

		}
	    
		/************************************************************************************
		 * Method: addOrder Description: To add the Orders to Database
		 * 
		 * @param addOrder: saves the order in the database
		 * @returns order: returns the response entity of order which is persisted
		 ************************************************************************************/

		// adding order
		@PostMapping
		public ResponseEntity<OrderModel> addOrder(@RequestBody OrderEntity order) throws OrderNotFoundException {
			return new ResponseEntity<>(adminService.addOrder(order), HttpStatus.OK);
		}
	    
		/**********************************************************************************************************************
		 * Method: deleteOrder Description: deleting a order by Id
		 * 
		 * @param deleteOrder: deletes orders based on particular order Id
		 * @returns order: returns the boolean response entity
		 ***********************************************************************************************************************/
		// deleting a product
		@DeleteMapping("/deleteorder/{id}")
		public ResponseEntity<Boolean> deleteOrder(@PathVariable(value = "id") Integer id)
				throws OrderNotFoundException {
			boolean value = adminService.deleteOrder(id);
			if (value == true)
				return ResponseEntity.ok(true);
			else
				return ResponseEntity.ok(false);
		}

	   

  


}
