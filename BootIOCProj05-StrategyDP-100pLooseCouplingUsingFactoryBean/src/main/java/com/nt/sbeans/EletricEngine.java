//EletricEngine.java
package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("eEngine")
@Lazy(true)
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
