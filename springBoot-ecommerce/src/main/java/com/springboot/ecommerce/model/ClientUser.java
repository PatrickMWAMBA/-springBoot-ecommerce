package com.springboot.ecommerce.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Client")
@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientUser {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(name = "first_name", nullable = false)
	private String firstname;
	
	@Column(name = "last_name", nullable = false)
	private String lastname;
	
	@Column(name = "e-mail", nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, length = 1000)
	private String password;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> addresses;
	
	@OneToMany(mappedBy = "client", orphanRemoval = true, cascade = CascadeType.ALL)
	private List <ClientOrders> orders;
	

}
