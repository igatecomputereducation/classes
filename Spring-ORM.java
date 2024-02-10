config.xml
-----------
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:p="http://www.springframework.org/schema/p"
	xmlns:tx="http://www.springframework.org/schema/tx"
	xmlns:util="http://www.springframework.org/schema/util"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context 
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/tx 
        http://www.springframework.org/schema/tx/spring-tx.xsd
        ">

	<tx:annotation-driven />

	<bean name="ds"	class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
		<property name="url" value="jdbc:mysql://localhost:3306/igate" />
		<property name="username" value="root" />
		<property name="password" value="" />
	</bean>


	<bean name="lsf" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
		<property name="dataSource" ref="ds" />
		<property name="hibernateProperties">
			<props>
				<prop key="hibernate.dialect">org.hibernate.dialect.MySQL57Dialect</prop>
				<prop key="hibernate.show_sql">true</prop>
				</props>
		</property>

		<property name="annotatedClasses">
			<list>
				<value>com.igate.Products</value>
			</list>
		</property>
	</bean>

	<bean name="ht"	class="org.springframework.orm.hibernate5.HibernateTemplate">
		<property name="sessionFactory" ref="lsf"></property>
	</bean>

	<bean name="transactionManager"	class="org.springframework.orm.hibernate5.HibernateTransactionManager">
		<property name="sessionFactory" ref="lsf" />
	</bean>

	<bean name="pdao" class="com.igate.DAOImpl">
		<property name="htemp" ref="ht" />
	</bean>

</beans>


Products.java
-------------
package com.igate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	@Id
	@Column(name="pcode")
	private int pcode;
	@Column(name="pname")
	private String pname;
	@Column(name="price")
	private double price;
	@Column(name="stock")
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
----------

package com.igate;

import java.util.List;

public interface DAO {
	int insertRecord(Products p);
	void updateRecord(Products p);
	void deleteRecord(int pcode);
	Products getProduct(int pcode);
	List<Products> getProducts();
}

DAOImpl.java
-------------
package com.igate;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class DAOImpl implements DAO{

	private HibernateTemplate htemp;
	

	public void setHtemp(HibernateTemplate htemp) {
		this.htemp = htemp;
	}

	@Transactional
	public int insertRecord(Products p) {
		int n=(Integer)htemp.save(p);
		return n; 
	}

	@Transactional
	public void updateRecord(Products p) {
		htemp.update(p);
	}

	@Transactional
	public void deleteRecord(int pcode) {
		Products st = htemp.get(Products.class, pcode);
		htemp.delete(st);
	}

	public Products getProduct(int pcode) {
		Products p=htemp.get(Products.class, pcode);
		return p;
	}

	public List<Products> getProducts() {
		List<Products> lst=htemp.loadAll(Products.class);
		return lst;
	}

}

Main.java
----------
package com.igate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		ApplicationContext con=new ClassPathXmlApplicationContext("config.xml");
		
		DAOImpl ob=con.getBean("pdao",DAOImpl.class);
				
		/*
		Products p=ob.getProduct(1003);
		System.out.println("pcode:"+p.getPcode());
		System.out.println("Name:"+p.getPname());
		System.out.println("Price:"+p.getPrice());
		System.out.println("Stock:"+p.getStock());
		*/
		
		
		/*
		List<Products> lst=ob.getProducts();
		for(Products p:lst) {
			System.out.println("pcode:"+p.getPcode());
			System.out.println("Name:"+p.getPname());
			System.out.println("Price:"+p.getPrice());
			System.out.println("Stock:"+p.getStock());
		}
		*/
		
		
		/*
		Products p=new Products();
		p.setPcode(1005);
		p.setPname("santhoor");
		p.setPrice(25.50);
		p.setStock(100);
		ob.insertRecord(p);
		*/
		
		
		/*
		Products p=new Products();
		p.setPcode(1002);
		p.setPname("rexona");
		p.setPrice(50.50);
		p.setStock(200);
		ob.updateRecord(p);
		*/
		
		
		ob.deleteRecord(1004);
		
		
		System.out.println("Hello world");
	}

}


