package com.igate;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class VoterIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		
		String vid="INDAP";
		vid=vid+new Random().nextInt(1000);
		return vid;
	}

}
