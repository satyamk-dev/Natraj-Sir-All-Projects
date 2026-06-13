package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Customer;

@Controller
public class CustomerOperationsController {
	
	
	@GetMapping("/")
	public  String  showHomePage() {
		//return LVN
		return "welcome";
	}
	
	@GetMapping("/register")  //for launching the form page
	public   String    showRegisterCustomerFormPage(@ModelAttribute("cust") Customer cust) {
		//return LVN
		return  "customer_register";
	}
	
	@PostMapping("/register") //for processing the form page
	public String  processFormPage(Map<String,Object> map,@ModelAttribute("cust") Customer cust) {
		System.out.println("CustomerOperationsController.processFormPage()::"+cust);
		//use form data for request processing
		if(cust.getBillamt()<5000.0)
			map.put("billAmt", cust.getBillamt());
		else
			map.put("billAmt", cust.getBillamt()-(cust.getBillamt()*0.1f));
		
		//return LVN
		return  "show_result";
		
	}
	
	

}
