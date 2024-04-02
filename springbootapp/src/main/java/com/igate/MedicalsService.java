package com.igate;

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
	
}
