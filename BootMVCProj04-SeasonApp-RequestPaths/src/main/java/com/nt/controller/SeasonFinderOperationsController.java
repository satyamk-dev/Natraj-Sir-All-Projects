//SeasonFinderOperationsController.java
package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		//keep the results in model attributes
		map.put("resultMsg", msg);
		//return LVN
		return "display";
		
	}
	
	//@RequestMapping({"/report1","/report2","/report3"})
	
	/*//@RequestMapping(value="/report",method = RequestMethod.GET)
	@GetMapping("/report")
	public   String  showReport1() {
		System.out.println("SeasonFinderOperationsController.showReport1()");
		//return lvn
		return "show_report1";
		
	}*/
	
	//@RequestMapping(value="/report",method=RequestMethod.POST)
	//@PostMapping("/report")
	@GetMapping("/report")
	public   String  showReport2() {
		System.out.println("SeasonFinderOperationsController.showReport2()");
		//return lvn
		//return "forward:/test/report";
		return "redirect:/test/report";
		
	}
	

}
