//RequestParamsDataBindingOperationsController.java
package com.nt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamsDataBindingOperationsController {
	
	/*@GetMapping("/data")
	public   String  showData(@RequestParam("sno") int no,
			                                        @RequestParam("sname") String name) {
		System.out.println("request param values ::"+no+"...."+name);
		//return LVN
		return "show_data";
		
	}*/
	
	
	/*@GetMapping("/data")
	public   String  showData(@RequestParam(defaultValue = "1345") Integer sno,
			                                        @RequestParam String sname) {
		System.out.println("request param values ::"+sno+"...."+sname);
		//return LVN
		return "show_data";
	}*/
	
	/*@GetMapping("/data")
	public   String  showData(@RequestParam(required = false) Integer sno,
			                                        @RequestParam(required = false) String sname) {
		System.out.println("request param values ::"+sno+"...."+sname);
		//return LVN
		return "show_data";
	}*/
	
	
	/*@GetMapping("/data")
	public   String  showData(@RequestParam(required = false,defaultValue = "1001") Integer sno,
			                                        @RequestParam(required = false,defaultValue = "ranveer") String sname) {
		System.out.println("request param values ::"+sno+"...."+sname);
		//return LVN
		return "show_data";
	}*/
	
	/*@GetMapping("/data")
	public   String  showData(@RequestParam Integer sno,
			                                        @RequestParam String sname,
			                                        @RequestParam  String[]  sadd,
			                                         @RequestParam(name="sadd") List<String> addrsList,
			                                         @RequestParam(name="sadd") Set<String> addrsSet) {
		System.out.println(sno+"...."+sname+"..."+Arrays.toString(sadd)+"...."+addrsList+"...."+addrsSet);
		
		//return LVN
		return  "show_data";
	}*/
	
	@GetMapping("/data")
	public   String  showData(@RequestParam Integer sno,
			                                        @RequestParam String sname,
			                                        @RequestParam  String  sadd) {
		System.out.println(sno+"...."+sname+"....."+sadd);
		//return LVN
		return "show_data";
	  }
	
	}
	
