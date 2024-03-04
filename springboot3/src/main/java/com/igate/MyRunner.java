package com.igate;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private Product p;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("in runner");

		System.out.println(p.getPcode());
		System.out.println(p.getPname());
		System.out.println(p.getPrice());
		System.out.println(p.getActive());
		
		List<String> flavor = p.getFlavor();
		System.out.println((String)flavor.get(0));
		System.out.println((String)flavor.get(1));
		
		
		Set<String> size = p.getSize();
		for(String str:size)
			System.out.println(str);
		
		Map<String, Double> gst = p.getGst();
		System.out.println(gst.get("igst"));
		System.out.println(gst.get("sgst"));
		
		Mfg ob = (Mfg)p.getOb();
		System.out.println(ob.getPlace());
		System.out.println(ob.getState());
	
	
	}
	
	

}
