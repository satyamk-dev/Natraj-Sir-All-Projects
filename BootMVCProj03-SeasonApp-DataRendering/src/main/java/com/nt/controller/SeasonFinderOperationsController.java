//SeasonFinderOperationsController.java
package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ISeasonMgmtService;

@Controller
public class SeasonFinderOperationsController {
	@Autowired
	private   ISeasonMgmtService  service;
	
	@RequestMapping("/")
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

}
