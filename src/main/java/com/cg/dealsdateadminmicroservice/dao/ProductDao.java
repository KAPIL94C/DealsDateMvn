package com.cg.dealsdateadminmicroservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.dealsdateadminmicroservice.entity.ProductCategory;
import com.cg.dealsdateadminmicroservice.entity.ProductEntity;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Integer> {

	
	


}
