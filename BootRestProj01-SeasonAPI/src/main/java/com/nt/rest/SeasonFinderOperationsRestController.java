//SeasonFinderOperationsRestController.java

package com.nt.rest;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/season-api")
public class SeasonFinderOperationsRestController {
	
	/*  // End point
	@GetMapping("/display")
	public   ResponseEntity<String>  showSesonName(){
		System.out.println("SeasonFinderOperationsRestController.showSesonName()");
		//  get  current season name
		  LocalDate date=LocalDate.now();
		  int month=date.getMonthValue();
		  String seasonName=null;
		  if(month>=3 && month<=6)
			    seasonName="Summer season";
		  else if(month>=7 && month<=10)
			  seasonName="Rainy Season";
		  else
			  seasonName="Winter SEason";
		  
		return new ResponseEntity<String>(seasonName, HttpStatus.CREATED);
	}*/
	
	  // End point
		@GetMapping("/display")
		public   String  showSesonName(){
			System.out.println("SeasonFinderOperationsRestController.showSesonName()");
			//  get  current season name
			  LocalDate date=LocalDate.now();
			  int month=date.getMonthValue();
			  String seasonName=null;
			  if(month>=3 && month<=6)
				    seasonName="Summer season";
			  else if(month>=7 && month<=10)
				  seasonName="Rainy Season";
			  else
				  seasonName="Winter SEason";
			  
			return seasonName;
		}	

}
