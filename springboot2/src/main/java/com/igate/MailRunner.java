package com.igate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(1)
public class MailRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Beg of mail runner");
		System.out.println("Connecting with mail server");
		System.out.println("Mail server is ready..");

	}

}
