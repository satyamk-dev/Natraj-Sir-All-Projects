package com.nt.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("bmcc")
public class BillingMSClientComp {
	@Autowired
	private  LoadBalancerClient  client;
	
	 public   String   invokeDoBilling() {
		 System.out.println("Client Comp class name ::"+client.getClass());
		  //get  Less Load factor Provider MS instance  by giving service id
		 ServiceInstance  si=client.choose("BillingMS");
		 //  get   Service URL of target MS
		 URI  url=si.getUri();
		 //complete url  by adding endpoint path
		 String urlInfo=url+"/billing-api/bill";
		 // create RestTemplate object
		 RestTemplate  template=new RestTemplate();
		 // invoke the method
		 ResponseEntity<String>  resp=template.exchange(urlInfo, HttpMethod.GET, null, String.class);
		 //get  body of the response
		 String  msg=resp.getBody();
		 return  msg;
	 }

}
