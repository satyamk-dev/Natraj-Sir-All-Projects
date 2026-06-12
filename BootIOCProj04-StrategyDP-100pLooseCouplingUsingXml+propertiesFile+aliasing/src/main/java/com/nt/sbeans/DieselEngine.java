//DieselEngine.java
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngine")
public class DieselEngine implements IEngine {

	@Override
	public void startEngine() {
		System.out.println("DieselEngine:: Engine Started");

	}

	@Override
	public void stopEngine() {
		System.out.println("DieselEngine:: Engine stopped");
	}

}
