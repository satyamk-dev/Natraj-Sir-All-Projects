package com.nt.main;

import com.nt.ston.Printer;

public class SingletonTest {

	public static void main(String[] args) {
		//get object
		Printer prn1=Printer.getInstance();
		Printer prn2=Printer.getInstance();
		
		System.out.println(prn1.hashCode()+" "+prn2.hashCode());
		System.out.println("prn1==prn2?"+(prn1==prn2));
		
	}

}
