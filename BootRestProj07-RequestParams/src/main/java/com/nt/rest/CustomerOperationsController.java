//CustomerOperationsController.java
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {
	
	
	/*@GetMapping("/report")
	public   ResponseEntity<String>  showReportByData(@RequestParam("sno") int no,
			                                                                                          @RequestParam("sname") String name){
		System.out.println("CustomerOperationsController.showReportByData():::"+no+"..."+name);
		
		return new ResponseEntity<String>("params ::"+no+"..."+name,HttpStatus.OK);
		
	}
	*/	
	
	/*@GetMapping("/report")
	public   ResponseEntity<String>  showReportByData(@RequestParam  int no,
			                                                                                          @RequestParam  String name){
		System.out.println("CustomerOperationsController.showReportByData():::"+no+"..."+name);
		
		return new ResponseEntity<String>("params ::"+no+"..."+name,HttpStatus.OK);
		
	}
	*/
	
	/*@GetMapping("/report")
	public   ResponseEntity<String>  showReportByData(@RequestParam(required = false)  Integer no,
			                                                                                          @RequestParam(required = false)  String name){
		System.out.println("CustomerOperationsController.showReportByData():::"+no+"..."+name);
		
		return new ResponseEntity<String>("params ::"+no+"..."+name,HttpStatus.OK);
		
	}*/
	
	@GetMapping("/report")
	public   ResponseEntity<String>  showReportByData(@RequestParam(required = false,defaultValue = "1001")  Integer no,
			                                                                                          @RequestParam(required = false,defaultValue = "rajesh")  String name){
		System.out.println("CustomerOperationsController.showReportByData():::"+no+"..."+name);
		
		return new ResponseEntity<String>("params ::"+no+"..."+name,HttpStatus.OK);
		
	}
	
}
