package com.igate;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

public class DaoImpl {
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	public void modifyProducts(String qry) {
		jt.update(qry);
	}
	
		
	public List<Products> getProducts(){
		String qry="select * from products";
		List<Products> list=jt.query(qry, new RowMapperImpl());
		return list;
	}
	
	public Products getProduct(int pcode){
		String qry="select * from products where pcode="+pcode;
		Products p=jt.queryForObject(qry, new RowMapperImpl());
		return p;
	}
	
	
}
