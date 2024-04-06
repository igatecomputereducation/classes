package com.igate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MedicalsService {
	@Autowired
	private ProductsRepository repo;
	
	public int createProduct(Products p) {
		Products r=repo.save(p);
		System.out.println(r.getPcode());
		return r.getPcode();
	}
	
	public List<Products> getAllProducts(){
		return (List<Products>) repo.findAll();
	}
	
	
	public void deleteProduct(int pcode) {
		repo.deleteById(pcode);
	}
	
	public Products getProduct(int pcode) {
		Optional<Products> byId = repo.findById(pcode);
		return byId.get();
	}
	
}
