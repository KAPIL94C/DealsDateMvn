package com.cg.dealsdateadminmicroservice.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dealsdateadminmicroservice.entity.OrderEntity;



@Repository
public interface AdminDao extends JpaRepository<OrderEntity, Integer> {

	
	






	
}

