package com.nt.ms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingMSClientComp;


@RestController
@RequestMapping("/shopping-api")
@RefreshScope
public class ShoppingMSOperationsController {
	@Autowired
	private   IBillingMSClientComp  clientComp;
	@Value("${db.user}")
	private  String username;
	@Value("${db.pwd}")
	private  String  password;
	
	@GetMapping("/shopping")
	public  ResponseEntity<String>  doShopping(){
		System.out.println("Client comp class name:: "+clientComp.getClass());
         //prepare shopping items
		  Map<String,Integer>  map=new HashMap<String, Integer>();
		  map.put("Table",1);
		  map.put("chair",6);
		  map.put("sofa",2);
		  //prepare the message
		  String  msg=map.toString();
		  //invoke  provider MS endpoint
		  String  msg1=clientComp.invokeDoBilling();
		  //prepare  final message
		  String finalMsg=msg+"...("+username+"..."+password+")...."+msg1;
		  //return ResponseEntity object
		  return   new ResponseEntity<String>(finalMsg,HttpStatus.OK);
		  
	}
	

}
