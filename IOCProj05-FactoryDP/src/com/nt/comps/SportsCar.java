//SportsCar.java
package com.nt.comps;

public class SportsCar implements ICar {
	
	public SportsCar() {
		System.out.println("SportsCar::0-param constructor");
	}

	@Override
	public void drive() {
		System.out.println("SportsCar.drive() ( Bucati)");
	}

}
