//CompanyOperationsController.java
package com.nt.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Employee;

@RestController
@RequestMapping("/company-api")
public class CompanyOperationsRestController {
	
	@GetMapping("/details") // Endpoint1
	public  ResponseEntity<Company> showCompanyDetails(){
		Company company=new Company(1001,"HCL","hyd");
		return new ResponseEntity<Company>(company,HttpStatus.OK);
	}
	
	@GetMapping("/emp-details")
	public ResponseEntity<Employee>  showEmployeeDetails(){
		 //create  employee data
		Employee  emp=new Employee(1001, "raja", new String[] { "ravi","suresh"},true,
				                                                      List.of("kind", "raj"),  Set.of(99999999L,888888888L),
				                                                      Map.of("aadhar","45454555454","pan","54545455"),
				                                                      new Company(1001,"HCL","hyd"));
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	
	@GetMapping("/all-companies")
	public  ResponseEntity<List<Company>> showAllCompanies(){
		//  prepare the objects
		Company  comp1=new Company(1001,"HCL", "hyd");
		Company  comp2=new Company(1002,"TCS", "BBSR");
		List<Company>  list=List.of(comp1, comp2);
		
		return new ResponseEntity<List<Company>>(list,HttpStatus.OK);
	}
	
	

}
