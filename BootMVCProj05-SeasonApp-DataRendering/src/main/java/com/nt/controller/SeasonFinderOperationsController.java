//SeasonFinderOperationsController.java
package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.Customer;
import com.nt.service.ISeasonMgmtService;

@Controller
public class SeasonFinderOperationsController {
	@Autowired
	private   ISeasonMgmtService  service;
	
	//@RequestMapping("/")
	@RequestMapping
	public   String showHomePage() {
		//return  LVN
		return "welcome";
	}
	
	@RequestMapping("/season")
	public  String  showSeason(Map<String,Object> map) {
		//use  service
		String msg=service.findSeason();
		//passing  simple values as the model attributes
		map.put("resultMsg", msg);
		map.put("age", new Random().nextInt(100));
		//passing  arrays and collections as model attributes
		map.put("favColors", new String[] {"red","green","blue"});
		map.put("friends",List.of("rajesh","suresh","mahesh"));
		map.put("phones",Set.of(999999L,8888888L,7777777L));
		map.put("idDetails",Map.of("aadhar",454545,"pan",4545454,"license",5454545));
		
		//add  Model  class object  as the model attribute value
		Customer cust=new Customer(1001,"rajesh","hyd",4545.0f);
		map.put("custData", cust);
		//  pass collection of model class obj  as model attribute value
		Customer cust1=new Customer(1001,"rajesh","hyd",4545.0f);
		Customer cust2=new Customer(1002,"suresh","vizag",1545.0f);
		Customer cust3=new Customer(1003,"sailesh","hyd",4545.0f);
		Customer cust4=new Customer(1004,"mukesh","vizag",1145.0f);
		List<Customer> custList=List.of(cust1,cust1,cust3,cust4);
		//add model attribute
		map.put("custList", custList);
		//return LVN
		return "display";
		
	}
	

}
