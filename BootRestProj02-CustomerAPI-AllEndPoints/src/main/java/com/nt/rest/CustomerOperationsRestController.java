package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsRestController {
	
	@PostMapping("/save")
	public   ResponseEntity<String>   saveCustomer(){
		System.out.println("CustomerOperationsRestController.saveCustomer()");
		return new ResponseEntity<String>("Customer is saved",HttpStatus.CREATED);
	}
	
	@GetMapping("/report")
	public   ResponseEntity<String>   getCustomerDetails(){
		System.out.println("CustomerOperationsRestController.getCustomerDetails()");
		return new ResponseEntity<String>("Customer Details are gathered",HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public   ResponseEntity<String>   updateCustomerDetails(){
		System.out.println("CustomerOperationsRestController.updateCustomerDetails()");
		return new ResponseEntity<String>("Customer Details are Updated",HttpStatus.OK);
	}
	
	@PatchMapping("/updateEmail")
	public   ResponseEntity<String>   updateCustomerEmail(){
		System.out.println("CustomerOperationsRestController.updateCustomerEmailDetails()");
		return new ResponseEntity<String>("Customer Email Details are Updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public   ResponseEntity<String>   deleteCustomer(){
		System.out.println("CustomerOperationsRestController.deleteCustomerDetails()");
		return new ResponseEntity<String>("Customer  Details are Deleted",HttpStatus.OK);
	}
	
	

}
