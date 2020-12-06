package com.cg.dealsdateadminmicroservice.service;

import java.util.List;

import com.cg.dealsdateadminmicroservice.entity.ProductEntity;
import com.cg.dealsdateadminmicroservice.exception.ProductNotFoundException;
import com.cg.dealsdateadminmicroservice.model.ProductModel;

public interface IProductService {
	
	
	

	// add products
	public ProductModel addProduct(ProductEntity product) throws ProductNotFoundException;
	
	//delete products
	public boolean deleteProduct(Integer id) throws ProductNotFoundException;

	// returns product with particular productId
	public ProductModel getProductById(Integer id) throws ProductNotFoundException;


	// display all products
	public List<ProductModel> displayListOfProducts();
	

	//update the product
	
	public ProductModel updateProduct(ProductModel requestData) throws ProductNotFoundException;

	

}
