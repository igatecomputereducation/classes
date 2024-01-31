//step1: creating table
user: root
password: 12345
database: igate

create table products(pcode int primary key,
pname varchar(30),
price decimal(8,2),
stock int);

config.xml
------------
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:p="http://www.springframework.org/schema/p"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
        
    <bean id="dmds" class="org.springframework.jdbc.datasource.DriverManagerDataSource" p:driverClassName="com.mysql.jdbc.Driver" p:url="jdbc:mysql://localhost:3306/igate" p:username="root" p:password="12345">
    </bean>
    
    <bean id="jt" class="org.springframework.jdbc.core.JdbcTemplate" p:dataSource-ref="dmds">
    </bean>
    
    <bean id="dao" class="com.igate.DAOImpl" p:jt-ref="jt">
    
    </bean>
</beans>

Products.java
--------------
package com.igate;
public class Products {
	private int pcode;
	private String pname;
	private double price;
	private int stock;
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}



DAO.java
---------
package com.igate;
import java.util.List;
public interface DAO {
	int addRecord(Products p);
	int delRecord(int pcode);
	int updateRecord(Products p);
	Products getRecord(int pcode);
	List<Products> getAllRecords();
}

DAOImpl.java
--------------
package com.igate;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
public class DAOImpl implements DAO{	
	private JdbcTemplate jt;
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	public int addRecord(Products p) {
		int n=0;
		try {
			String qry=String.format("insert into products values(%d,'%s',%f,%d)",p.getPcode(),p.getPname(),p.getPrice(),p.getStock());
			n=jt.update(qry);
		}
		catch(Exception e) {
			System.out.println("Violating primary constraint");
			n=0;
		}
		return n;
	}
	public int delRecord(int pcode) {
		String qry=String.format("delete from products where pcode=%d",pcode);
		int n=jt.update(qry);
		return n;
	}
	public int updateRecord(Products p) {
		String qry=String.format("update products set price=%f, stock=%d where pcode=%d",p.getPrice(),p.getStock(),p.getPcode());
		int n=jt.update(qry);
		return n;
	}
	public Products getRecord(int pcode){
		Products p=null;
		try {
			String qry=String.format("select * from products where pcode=%d",pcode);
			p=jt.queryForObject(qry,new RowMapperImpl());
		}
		catch(Exception e) {
			System.out.println("No such pcode available");
		}
		return p;
	}
	public List<Products> getAllRecords(){
		
		String qry="select * from products";
		List<Products> lst=jt.query(qry, new RowMapperImpl());
		return lst;
	}
}


RowMapperImpl.java
------------------
package com.igate;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class RowMapperImpl implements RowMapper<Products> {
	@Override
	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		Products r=new Products();
		r.setPcode(rs.getInt(1));
		r.setPname(rs.getString(2));
		r.setPrice(rs.getFloat(3));
		r.setStock(rs.getInt(4));
		return r;
	}

}


Main.java
---------
package com.igate;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext con=new ClassPathXmlApplicationContext("config.xml");
		
		DAOImpl ob=(DAOImpl)con.getBean("dao");
		
		//adding record
		/*
		Products p=new Products();
		p.setPcode(1002);
		p.setPname("Liril");
		p.setPrice(50.50);
		p.setStock(80);
		
		int n=ob.addRecord(p);
		System.out.println(n+" Records inserted");
		*/
		
		//deleting record
		/*
		int n=ob.delRecord(1002);
		System.out.println(n+" Records deleted");
		*/
		
		//modifying record
		/*
		Products p=new Products();
		p.setPcode(1001);
		p.setPrice(75.50);
		p.setStock(100);
		
		int n=ob.updateRecord(p);
		System.out.println(n+" Records updated");
		
		*/
		
		//getting singe record
		/*
		Products p=ob.getRecord(1005);
		if(p!=null)
		{
			System.out.println("PCode:"+p.getPcode());
			System.out.println("Name:"+p.getPname());
			System.out.println("Price:"+p.getPrice());
			System.out.println("Stock:"+p.getStock());
		}
		*/
		
		//getting multiple records
		List<Products> lst=ob.getAllRecords();
		if(lst.isEmpty())
			System.out.println("Table is empty");
		else
		{
			for(Products p:lst)
			{
				System.out.println("PCode:"+p.getPcode());
				System.out.println("Name:"+p.getPname());
				System.out.println("Price:"+p.getPrice());
				System.out.println("Stock:"+p.getStock());
				System.out.println("--------------------------");
			}
		}
		
	}

}

