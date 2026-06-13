//A.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("a1")
public class A {
	@Autowired
	private B b;
	
	/*	@Autowired
		public   A(B b) {
			System.out.println("A.A()");
			this.b=b;
		}*/
	
	/*@Autowired
	public void setB(B b) {
		System.out.println("A.setB()");
		this.b=b;
	}*/
	
	/*@Autowired
	public void putB(B b) {
		System.out.println("A.putB()");
		this.b=b;
	}*/

	//toString()
	@Override
	public String toString() {
		return "A []";
	}
	
	
	

}
