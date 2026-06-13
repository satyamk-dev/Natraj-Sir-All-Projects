package com.nt.main;

import com.nt.comps.ICar;
import com.nt.factory.CarFactory;

public class FactoryPatternSolution {

	public static void main(String[] args) {
		//By calling static factory method of Factroy Pattern class 
		//we can  enjoy abstration on object creation process
		ICar car1=CarFactory.getInstance("standard");
		car1.drive();
		System.out.println("-----------------------------");
		ICar car2=CarFactory.getInstance("luxory");
		car2.drive();
		System.out.println("-----------------------------");
		ICar car3=CarFactory.getInstance("sports");
		car3.drive();
		System.out.println("-----------------------------");
		
	}

}
