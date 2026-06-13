//CompanyOperationsRestController.java
package com.nt.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Employee;

@RequestMapping("/company-api")
@RestController
public class CompanyOperationsRestController {
	
	@PostMapping("/register-company")
	public  ResponseEntity<String>  registerCompany(@RequestBody Company company){
		System.out.println("CompanyOperationsRestController.registerCompany()::: data -->"+company);
		return new ResponseEntity<String>(" Company registered ::"+company,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/register-employee")
	public  ResponseEntity<String>  registerEmployee(@RequestBody Employee  emp){
		System.out.println("CompanyOperationsRestController.registerEmployee()::: data -->"+emp);
		return new ResponseEntity<String>("Employee is registered ::"+emp,HttpStatus.CREATED);
	}
	
	@PostMapping("/register-companies")
	public  ResponseEntity<String>  regitserMultipleCompanies(@RequestBody List<Company> list ){
		System.out.println("CompanyOperationsRestController.regitserMultipleCompanies()");
		return  new  ResponseEntity(list.size()+"companies are registered"+list, HttpStatus.OK);
		
	}
	

}
