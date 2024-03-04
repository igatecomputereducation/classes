package com.igate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AddressRunner implements CommandLineRunner {

	@Autowired
	private Address ob;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(ob.getName());
		System.out.println(ob.getDno());
		System.out.println(ob.getStreet());
		System.out.println(ob.getPlace());
	}
}