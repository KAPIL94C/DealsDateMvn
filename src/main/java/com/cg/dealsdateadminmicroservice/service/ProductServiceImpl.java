package com.cg.dealsdateadminmicroservice.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dealsdateadminmicroservice.dao.ProductDao;
import com.cg.dealsdateadminmicroservice.entity.ProductEntity;
import com.cg.dealsdateadminmicroservice.exception.ProductNotFoundException;
import com.cg.dealsdateadminmicroservice.model.ProductModel;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductDao repo;

	// converting model to entity
	public ProductEntity of(ProductModel source) {
		ProductEntity result = null;
		if (source != null) {
			result = new ProductEntity();
			result.setProductId(source.getProductId());
			result.setProductName(source.getProductName());
			result.setProductPrice(source.getProductPrice());
			result.setProductCategory(source.getProductCategory());
			result.setProductQuantity(source.getProductQuantity());
			result.setProductSpecification(source.getProductSpecification());
			result.setProductColor(source.getProductColor());
			result.setImageUrl(source.getImageUrl());

		}
		return result;
	}

	// converting entity to model
	public ProductModel of(ProductEntity source) {
		ProductModel result = null;
		if (source != null) {
			result = new ProductModel();
			result.setProductId(source.getProductId());
			result.setProductName(source.getProductName());
			result.setProductPrice(source.getProductPrice());
			result.setProductCategory(source.getProductCategory());
			result.setProductQuantity(source.getProductQuantity());
			result.setProductSpecification(source.getProductSpecification());
			result.setProductColor(source.getProductColor());
			result.setImageUrl(source.getImageUrl());
		}
		return result;
	}

	/************************************************************************************
	 * Method: addProduct Description: To add the Products to Database
	 * 
	 * @param existById: check for the productId if already exits
	 * @param save:      saves the product in the database
	 * @returns product: returns the product which is persisted
	 ************************************************************************************/

	// adding products to database
	@Override
	public ProductModel addProduct(ProductEntity product) throws ProductNotFoundException {
		if (product == null) {
			throw new ProductNotFoundException("Product Should not be null");
		}
		if (repo.existsById(product.getProductId())) {

			throw new ProductNotFoundException("This Product already exist !");
		}
		return of(repo.save(product));

	}


	/*********************************************************************************************
	 * Method: displayListOfProducts Description: display all products details from
	 * the table
	 * 
	 * @param findAll: fetches complete list of products
	 * @returns List<ProductModel>: returns the list of products
	 *********************************************************************************************/

	// display all products details from the table
	@Override
	public List<ProductModel> displayListOfProducts() {
		return repo.findAll().stream().map(entity -> of(entity)).collect(Collectors.toList());
	}

	

	


	

	/**********************************************************************************************************************
	 * Method: getProductById Description: returns specific product by Id
	 * 
	 * @param findById: fetches products based on productid
	 * @returns Product returns products
	 ***********************************************************************************************************************/
	// returns specific product by Id
	@Override
	public ProductModel getProductById(Integer id) throws ProductNotFoundException {
		if (id == null) {
			throw new ProductNotFoundException("Product id should not be null");
		} else {
			Optional<ProductEntity> entity = repo.findById(id);
			return entity.isPresent() ? of(entity.get()) : null;
		}
	}

	/**********************************************************************************************************************
	 * Method: deleteProduct Description: deleting a product by Id
	 * 
	 * @param findById: fetches products based on particular productId
	 * @param delete:   deletes products based on particular product Id
	 ***********************************************************************************************************************/
	// deleting a product
	@Override
	public boolean deleteProduct(Integer id) throws ProductNotFoundException {
		boolean flag = false;
		if (id == null) {
			throw new ProductNotFoundException("Product id should not be null");
		}
		else {
			repo.deleteById(id);
			flag = true;
		}
		return flag;
	}
	
	/**********************************************************************************************************************
	 * Method: updateProduct Description: updating a product by Id
	 * 
	 
	 * @param existById: check for the productId if already exits
	 * @param save:      saves the product in the database
	 * @returns product: returns the product which is persisted
	 ***********************************************************************************************************************/
	// update a product
	
	
	 public ProductModel updateProduct(ProductModel product) throws ProductNotFoundException {
	        
	    	boolean exists =repo.existsById(product.getProductId());
	    	if(!exists) {
	    		throw new ProductNotFoundException("Product does not exist !");
	    	}
	    	product = of(repo.save(of(product)));
	        return product;
	    }
	 

}
