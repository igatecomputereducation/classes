package com.igate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MedicalController {

	@Autowired
	private MedicalsService service;
	
	@GetMapping("/hello")
	public String displayHello() {
		return "hello";
	}
	
	@GetMapping("/inputproduct")
	public String inputProduct() {
		return "inputproduct";
	}
	
	@PostMapping("/crproduct")
	public String createProduct(@ModelAttribute Products p,RedirectAttributes m) {
		int pid=service.createProduct(p);
		m.addFlashAttribute("pid", pid);
		return "redirect:inputproduct";
	}
	
}
