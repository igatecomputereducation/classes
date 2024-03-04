package com.igate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties("pro")
public class Product {
	private int pcode;
	private String pname;
	private double price;
	private boolean active;
	private List<String> flavor;
	private Set<String> size;
	private Map<String,Double> gst;
	private Mfg ob;
	
	public Set<String> getSize() {
		return size;
	}
	public void setSize(Set<String> size) {
		this.size = size;
	}
	public Mfg getOb() {
		return ob;
	}
	public void setOb(Mfg ob) {
		this.ob = ob;
	}
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public List<String> getFlavor() {
		return flavor;
	}
	public void setFlavor(List<String> flavor) {
		this.flavor = flavor;
	}
	public Map<String, Double> getGst() {
		return gst;
	}
	public void setGst(Map<String, Double> gst) {
		this.gst = gst;
	}
	
	
}
