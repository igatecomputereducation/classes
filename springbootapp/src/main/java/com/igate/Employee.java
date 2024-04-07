package com.igate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
	private String ename;
	private String gender;
	private int basic;
	private boolean active;
	private String grade;
}
