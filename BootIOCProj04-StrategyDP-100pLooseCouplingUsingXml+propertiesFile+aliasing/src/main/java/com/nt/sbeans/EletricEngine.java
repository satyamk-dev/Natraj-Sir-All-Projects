//EletricEngine.java
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("eEngine")
public class EletricEngine implements IEngine {

	@Override
	public void startEngine() {
		System.out.println("EletricEngine:: Engine Started");

	}

	@Override
	public void stopEngine() {
		System.out.println("EletricEngine:: Engine stopped");
	}

}
