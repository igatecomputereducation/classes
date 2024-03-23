package com.igate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class VoterRunner implements CommandLineRunner {

	@Autowired
	private VoterRepository vrep;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Voters v=new Voters();
		v.setVname("Narayana");
		v.setGender("Male");
		
		vrep.save(v);
	}

}
