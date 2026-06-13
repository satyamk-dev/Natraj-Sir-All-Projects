//A.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("b1")
public class B {
	@Autowired
	private A a;
	
	/*public B(A a) {
		System.out.println("B.B()");
		this.a=a;
	}*/

	/*@Autowired
	public void setA(A a) {
		System.out.println("B.setA()");
		this.a=a;
	}*/
	
	
	@Autowired
	public void assignA(A a) {
		System.out.println("B.assignA()");
		this.a=a;
	}
	
	
	//toString()
	@Override
	public String toString() {
		return "B []";
	}

}
