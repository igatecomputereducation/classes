web.xml
---------
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
  <display-name>my first mvc app</display-name>
  <servlet>
  		<servlet-name>dispatcher</servlet-name>
  		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  		<init-param>
	        <param-name>contextConfigLocation</param-name>
	        <param-value>/WEB-INF/spring-config.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
  		<servlet-name>dispatcher</servlet-name>
  		<url-pattern>/</url-pattern>
  </servlet-mapping>
</web-app>


spring-config.xml
------------------
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns:context="http://www.springframework.org/schema/context"
  xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context 
    http://www.springframework.org/schema/context/spring-context.xsd">
  
  <context:component-scan base-package="com.igate"/>
  
  <bean name="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
  		<property name="prefix" value="/WEB-INF/views/"></property>
  		<property name="suffix" value=".jsp"></property>
  </bean>

</beans>


MyController.java
-------------------
package com.igate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MyController {
	@RequestMapping("/hello")
	public String getHello() {
		return "hello"; 
	}
}


hello.jsp
---------------
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">This is my first MVC program</h1>
</body>
</html>


