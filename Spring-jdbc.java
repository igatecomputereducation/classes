//config.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:p="http://www.springframework.org/schema/p"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    <bean id="dmds" class="org.springframework.jdbc.datasource.DriverManagerDataSource" 
    	p:driverClassName="com.mysql.jdbc.Driver" 
    	p:url="jdbc:mysql://localhost:3306/igate" 
    	p:username="root" p:password="12345">
    	<!--  
    	<property name="driverClassName" value="com.mysql.jdbc.Driver">
    	</property>
    	<property name="url" value="jdbc:mysql://localhost:3306/igate">
    	</property>
    	<property name="username" value="root">
    	</property>
    	<property name="password" value="12345">
    	</property>
    	-->
    </bean>
    
    <bean id="jt" class="org.springframework.jdbc.core.JdbcTemplate" 
    p:dataSource-ref="dmds">
    	<!--  
    	<property name="dataSource" ref="dmds">
    	</property>
    	-->
    </bean>
</beans>

//Student.java
package com.igate;

public class Students {
	private int regdno;
	private String sname;
	public int getRegdno() {
		return regdno;
	}
	public void setRegdno(int regdno) {
		this.regdno = regdno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}


//RowMapperImpl.java
package com.igate;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class RowMapperImpl implements RowMapper<Students> {

	@Override
	public Students mapRow(ResultSet rs, int rowNum) throws SQLException {
		Students s=new Students();
		s.setRegdno(rs.getInt(1));
		s.setSname(rs.getString(2));
		return s;
	}
	
}

//Main.java
package com.igate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext con=new ClassPathXmlApplicationContext("config.xml");
		JdbcTemplate ob=(JdbcTemplate)con.getBean("jt");

		//int x=ob.update("insert into students values(1000,'Prakash')");
		
		/*
		String sql="insert into students values(?,?)";
		int x=ob.update(sql,1001,"Narasimha");
		System.out.println(x+" no of records updated");
		*/
		
		Students s=(Students)ob.queryForObject("select * from students where regdno=1002",new RowMapperImpl());
		System.out.println(s.getRegdno());
		System.out.println(s.getSname());
	}

}
