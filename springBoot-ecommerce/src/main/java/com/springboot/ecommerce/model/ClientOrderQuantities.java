package com.springboot.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ClientOrderQuantities {
	
	@Id
	@Column(name = "id", nullable = false, unique = true )
	private long id;
	
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name = "quantity(s)", nullable = false )
	int quantity;
	
	@ManyToOne(optional= false)
	@JoinColumn(name = "order_id",nullable = false)
	private ClientOrders orders;

}
