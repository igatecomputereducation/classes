//spring-namespace-demo
//Student.java
//--------------
package com.igate;
public class Student1 {
	private String sname;
	private String course;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
}

//Student2.java
//-------------
package com.igate;
public class Student2 {
	private String sname;
	private String course;
	public Student2(String sname, String course) {
		super();
		this.sname = sname;
		this.course = course;
	}
	public String getSname() {
		return sname;
	}
	public String getCourse() {
		return course;
	}
	
}

//Hello.java
//------------
package com.igate;
public class Hello {
	public void sayHello() {
		System.out.println("Hello world");
	}
}

//Publish.java
//-------------
package com.igate;

public class Publish {
	private Hello msg;

	public void setMsg(Hello msg) {
		this.msg = msg;
	}
	public void display() {
	    msg.sayHello();
	}
	
}

//Main.java
//---------
package com.igate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext con=new ClassPathXmlApplicationContext("config.xml");

		
		Student1 s1=con.getBean("s1",com.igate.Student1.class);
		System.out.println(s1.getSname());
		System.out.println(s1.getCourse());
		
		Student2 s2=con.getBean("s2",com.igate.Student2.class);
		System.out.println(s2.getSname());
		System.out.println(s2.getCourse());
		
		Publish p=(Publish)con.getBean("pub");
		p.display();
		
	}

}

//Config.xml
//----------
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:p="http://www.springframework.org/schema/p"
    xmlns:c="http://www.springframework.org/schema/c"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<!--  

    <bean id="s1" class="com.igate.Student1">
    	<property name="sname" value="Vishnu"></property>
    	<property name="course" value="B.Tech"></property>
    </bean>
    
    <bean id="s2" class="com.igate.Student2">
    	<constructor-arg name="sname" value="Brahma"></constructor-arg>
    	<constructor-arg name="course" value="MCA"></constructor-arg>
    </bean>
    
    <bean id="h" class="com.igate.Hello">
	</bean>
	
	<bean id="pub" class="com.igate.Publish">
		<property name="msg" ref="h"></property>
	</bean>
    
    -->
	

	<bean id="s1" class="com.igate.Student1" p:sname="Vishnu" p:course="B.Tech"/>
	<bean id="s2" class="com.igate.Student2" c:sname="Brahma" c:course="MCA"/>
	
	<bean id="h" class="com.igate.Hello"/>
	<bean id="pub" class="com.igate.Publish" p:msg-ref="h"/>	
</beans>
