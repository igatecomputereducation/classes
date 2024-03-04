package com.igate;

import org.springframework.stereotype.Component;

@Component
public class Mfg {
	private String place;
	private String state;
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
