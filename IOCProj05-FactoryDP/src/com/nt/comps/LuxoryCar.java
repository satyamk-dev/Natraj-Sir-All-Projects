//LuxoryCar.java
package com.nt.comps;

public class LuxoryCar implements ICar {
	
	public LuxoryCar() {
		System.out.println("LuxoryCar: 0-param construtor");
	}

	@Override
	public void drive() {
		System.out.println("LuxoryCar.drive() ( BMV  S7)");
	}

}
