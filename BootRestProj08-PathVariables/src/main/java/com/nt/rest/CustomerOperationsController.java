package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {

	/*@GetMapping("/report/{cno}/{cname}")
	public   ResponseEntity<String>  showReportByData(@PathVariable("cno") int no,
			                                                                                           @PathVariable("cname") String name){
		System.out.println("CustomerOperationsController.showReportByData()::  "+no+"...."+name);
		
		return new ResponseEntity<String>("path variable values ::"+no+"..."+name, HttpStatus.OK);
	}*/
	
	/*	@GetMapping("/report/{cno}/{cname}")
		public   ResponseEntity<String>  showReportByData(@PathVariable int cno,
				                                                                                           @PathVariable String cname){
			System.out.println("CustomerOperationsController.showReportByData()::  "+cno+"...."+cname);
			
			return new ResponseEntity<String>("path variable values ::"+cno+"..."+cname, HttpStatus.OK);
		}
	*/
	
	@GetMapping({"/report/{cno}/{cname}","/report/{cno}","/report" })
	public   ResponseEntity<String>  showReportByData(@PathVariable(required = false) Integer cno,
			                                                                                           @PathVariable(required = false) String cname){
		System.out.println("CustomerOperationsController.showReportByData()::  "+cno+"...."+cname);
		
		return new ResponseEntity<String>("path variable values ::"+cno+"..."+cname, HttpStatus.OK);
	}
	
}
