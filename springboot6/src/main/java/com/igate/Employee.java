package com.igate;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="empno")
	private int empno;
	
	@Column(name="ename")
	private String ename;
	
	@Column(name="dofj")
	@Temporal(TemporalType.DATE)
	private Date dofj;
	
	@Column(name="scode")
	private String scode;
	
}
