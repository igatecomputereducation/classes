package com.igate;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
	
	@GetMapping("/emp")
	public String getEmp() {
		return "emp";
	}
	
	@PostMapping("/empprocess")
	
	public String processEmp(@ModelAttribute Employee e,Model m) {
		
		m.addAttribute("emp", e);
		System.out.println("hello world");
		return "empprocess";
	}
}
