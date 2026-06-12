//Vehicle.java
package com.nt.sbeans;

import jakarta.annotation.Resource;
import jakarta.inject.Named;

@Named("vehicle")
public class Vehicle {
	
	@Resource(name="eEngine")
	private IEngine  engg;
	
	
	public  void  journey(String  startPlace,String destPlace) {
		engg.startEngine();
		System.out.println("Vehicle:: Vehicle started from ::"+startPlace);
		
		System.out.println("Vehicle:: Jounery is going  on ....");
		
		System.out.println("Vehicle:: Vehicle stopped at ::"+destPlace);
		engg.stopEngine();
	}

}
