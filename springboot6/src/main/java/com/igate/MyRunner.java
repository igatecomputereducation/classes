package com.igate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class MyRunner implements CommandLineRunner {
	
	@Autowired
	private MyRepository cr;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello world");
		
		
		Employee ob=new Employee();
		ob.setEname("Suresh");
		ob.setDofj(new Date());
		
		
		cr.save(ob);
		
	}
}
