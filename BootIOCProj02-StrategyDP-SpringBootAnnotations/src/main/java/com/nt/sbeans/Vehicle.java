//Vehicle.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {
	@Autowired
	@Qualifier("dEngine")
	private IEngine  engg;
	
	
	public  void  journey(String  startPlace,String destPlace) {
		engg.startEngine();
		System.out.println("Vehicle:: Vehicle started from ::"+startPlace);
		
		System.out.println("Vehicle:: Jounery is going  on ....");
		
		System.out.println("Vehicle:: Vehicle stopped at ::"+destPlace);
		engg.stopEngine();
	}

}
