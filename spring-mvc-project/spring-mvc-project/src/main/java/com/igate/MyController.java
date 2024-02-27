package com.igate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@Autowired
	private DaoImpl daoimpl;
	
	@RequestMapping("/test")
	public String getTest() {
		String sql="insert into products values(1003,'Garden chair',1000,20)";
		daoimpl.insertProducts(sql);
		return "test";
	}
	
	@RequestMapping("/crproducts")
	public String products_crproducts() {
		return "crproducts";
	}
	
	@RequestMapping(path="/dbcrproducts",method=RequestMethod.POST)
	public String products_dbcrproducts(@RequestParam("pcode")int pcode,@RequestParam("pname")String pname,@RequestParam("price")float price,@RequestParam("stock")int stock) {
		String qry=String.format("insert into products values(%d,'%s',%f,%d)", pcode,pname,price,stock);
		daoimpl.insertProducts(qry);
		return "redirect:dispproducts";
	}
	
	@RequestMapping("/dispproducts")
	public ModelAndView products_dispproducts() {
		ModelAndView m=new ModelAndView();
		m.addObject("lst",daoimpl.getProducts());
		m.setViewName("dispproducts");
		return m;
	}
	
	@RequestMapping("/delproducts/{pcode}")
	public String products_delproducts(@PathVariable("pcode")int pcode) {
		String qry="delete from products where pcode="+pcode;
		System.out.println(qry);
		daoimpl.deleteProducts(qry);
		return "redirect:../dispproducts";
	}
	
	@RequestMapping("/updateproducts/{pcode}")
	public String products_updateproducts(@PathVariable("pcode")int pcode) {
		ModelAndView m=new ModelAndView();
		Products p=daoimpl.getProduct(pcode);
		m.addObject("det",p);
		m.setViewName("");
		
	}
	
	
}
