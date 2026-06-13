//BillingOperationsController.java
package com.nt.ms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/billing-api")
@RefreshScope
public class BillingOperationsController {
	@Value("${spring.application.instance-id}")
	private   String  instanceId;
	@Value("${db.user}")
	private   String  username;
	@Value("${db.pwd}")
	private  String password;
	
	@GetMapping("/bill")
	public  ResponseEntity<String>   doBillling(){
		//generate  bill amount
		double bamt=new Random().nextDouble(200000);
		
		//return  RepsonseEntity object
		return new ResponseEntity<String>("Bill Amount::"+ bamt+"..."+instanceId+"...("+username+"..."+password+")",HttpStatus.OK);
		
		
	}

}
