package com.igate;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="voters")
@Data
public class Voters {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "com.igate.VoterIdGenerator")
	@Column(name="vid")
	private String vid;
	
	@Column(name="vname")
	private String vname;
	
	@Column(name="gender")
	private String gender;
	
}
