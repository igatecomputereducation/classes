package com.igate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	@GetMapping("/data")
	public String sendData(Model m) {
		m.addAttribute("empno",1000);
		m.addAttribute("ename","scott");
		m.addAttribute("salary",12000);
		m.addAttribute("active", true);
		return "data";
	}
	
	@GetMapping("/sendobj")
	public String sendObject(Model m) {
		Student s=new Student("Raviteja","BTech",3);
		m.addAttribute("obj",s);
		return "sendobj";
	}
	
	@GetMapping("/sendcoll")
	public String sendCollection(Model m) {
		List<Student> list=Arrays.asList(
				new Student("Kavitha","Bsc",3),
				new Student("Nagaraju","BCom",2),
				new Student("Bhavani","BCA",3)
		);	
		m.addAttribute("list", list);
		return "sendcoll";
	}
	
	@GetMapping("/dispstud")
	public String dispStudent() {
		
		return "dispstud";
	}
	
	@PostMapping("/crstud")
	public String createStudent(@ModelAttribute Student st,Model m) {
		m.addAttribute("stud", st);
		return "crstud";
		
	}
	
	
}
