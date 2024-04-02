package com.igate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Products {
	
	@Id
	@Column(name="pcode")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pcode;
	
	@Column(name="pname")
	private String pname;
	
	@Column(name="company")
	private String company;
	
	@Column(name="category")
	private String category;
	
	@Column(name="price")
	private double price;
	
	@Column(name="stock")
	private int stock;
	
}
