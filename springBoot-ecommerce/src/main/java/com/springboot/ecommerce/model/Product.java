package com.springboot.ecommerce.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", nullable = false, unique = true)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(name = "short_description",  nullable = false, unique = true)
	private String shortDescription;
	
	@Column(name = "long_description",  nullable = true, unique = true)
	private String longDescription;
	
	@Column(nullable = false, unique = false)
	private BigDecimal price;
	
	
	//@ManyToOne(optional = false,  cascade = CascadeType.REMOVE )
	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
	@JoinColumn(name = "product_id")
	private Inventory inventory;
	

}
