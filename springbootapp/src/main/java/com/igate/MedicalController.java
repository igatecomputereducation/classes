package com.igate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		m.addFlashAttribute("pid", "Product with pcode "+pid+" is inserted");
		return "redirect:all";
	}
	
	@GetMapping("/all")
	public String displayAllProducts(Model m) {
		List<Products> allpro= service.getAllProducts();
		m.addAttribute("all", allpro);
		return "all";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("pcode")Integer pcode) {
		service.deleteProduct(pcode);
		return "redirect:all";
	}
	
	@GetMapping("/update")
	public String displayUpdateProduct(@RequestParam("pcode")Integer pcode, Model m) {
		Products p=service.getProduct(pcode);
		m.addAttribute("ob", p);
		return "update";
	}
	
	@GetMapping("/emp")
	public String displayEmployee(Model m) {
		Employee e=new Employee("Narasimha", "M", 12000, false, "C");
		m.addAttribute("ob", e);
		return "emp";
	}
	
	
	
	
}
