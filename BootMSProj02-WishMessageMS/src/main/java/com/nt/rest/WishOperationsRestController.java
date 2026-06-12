package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish-api")
public class WishOperationsRestController {
	@Value("${spring.application.instance-id}")
	private  String instanceId;

	@GetMapping("/display")
	public   ResponseEntity<String>  showWishMessage(){
		//return  ResponseEntity object
		return new ResponseEntity<String>("Good Morning -->from:::"+instanceId,HttpStatus.OK);
	}
}
