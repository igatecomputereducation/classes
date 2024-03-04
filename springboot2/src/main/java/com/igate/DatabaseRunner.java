package com.igate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(2)
public class DatabaseRunner implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Statements in database runner");
		System.out.println("Connecting with database..");
		System.out.println("Loading data intto H2 ");
	}
}
