package com.nt.controller;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.model.Customer;

@Controller
public class CustomerOperationsController {
	
	@GetMapping("/")
	public  String  showHomePagge(Map<String,Object> map) {
		 //add model attributes  to shared memory
		map.put("distance", new Random().nextLong(400000000));
		map.put("price", new Random().nextFloat(40000.0f));
        map.put("avg", new Random().nextFloat(10.0f));		
        
        map.put("sysDate",new Date());
		
		//return LVN
		return "welcome";
	}
	
	@GetMapping("/register")
	public  String  showFormPage(@ModelAttribute("cust") Customer cust) {
		//return LVN
		return  "show_customer_form";
	}

}
