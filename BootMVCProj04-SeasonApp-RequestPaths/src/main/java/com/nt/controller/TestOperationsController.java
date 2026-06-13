//TestOperationsController.java
package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestOperationsController {

	@GetMapping("/report")
	public   String  showReportData() {
		System.out.println("TestOperationsController.showReportData()");
		//return lvn
		return "show_test_report";
	}
}
