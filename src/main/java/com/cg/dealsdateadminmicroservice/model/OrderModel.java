package com.cg.dealsdateadminmicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Order_table")
public class OrderModel {

	@Id
	@Column(name = "OrderId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@SequenceGenerator(sequenceName = "order_seq", initialValue = 100, allocationSize = 1, name = "order_seq")
	private Integer orderId;


	@Column(name="OrderStatus")
	private String orderStatus;

	@Column(name="PaymentMethod")
	private String paymentMethod;

	@Column(name="OrderQuantity")
	private Integer orderQuantity;



	public OrderModel() {
	super();
	}



	public Integer getOrderId() {
		return orderId;
	}



	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}



	public String getOrderStatus() {
		return orderStatus;
	}



	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}



	public String getPaymentMethod() {
		return paymentMethod;
	}



	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}



	public Integer getOrderQuantity() {
		return orderQuantity;
	}



	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}



	public OrderModel(Integer orderId, String orderStatus, String paymentMethod, Integer orderQuantity) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.paymentMethod = paymentMethod;
		this.orderQuantity = orderQuantity;
	}

}

