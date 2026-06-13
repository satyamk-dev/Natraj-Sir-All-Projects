//FactoryPatternProblem.java (Client App)
package com.nt.main;

import com.nt.comps.LuxoryCar;
import com.nt.comps.SportsCar;
import com.nt.comps.StandardCar;

public class FactoryPatternProblem {

	public static void main(String[] args) {
		//Here  we should  know  the process of creating each  class object 
		StandardCar car1=new StandardCar();
		car1.drive();
		System.out.println("-----------------------");
		LuxoryCar car2=new LuxoryCar();
		car2.drive();
		System.out.println("-----------------------");
		SportsCar car3=new SportsCar();
		car3.drive();
			
		

	}

}
