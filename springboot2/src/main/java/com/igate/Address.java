package com.igate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties("emp")
public class Address {
	private String name; 
	private String dno;
	private String street;
	private String place;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getName() {
		return name;
	}
	public String getDno() {
		return dno;
	}
	public String getStreet() {
		return street;
	}
	public String getPlace() {
		return place;
	}
	
}
