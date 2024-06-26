package com.igate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperImpl implements RowMapper<Products>{

	@Override
	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		Products p=new Products();
		p.setPcode(rs.getInt(1));
		p.setPname(rs.getString(2));
		p.setPrice(rs.getFloat(3));
		p.setStock(rs.getInt(4));
		return p;
	}
	
}
