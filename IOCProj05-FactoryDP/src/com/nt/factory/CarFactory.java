//CarFactory.java (FactoryPattern class)
package com.nt.factory;

import com.nt.comps.ICar;
import com.nt.comps.LuxoryCar;
import com.nt.comps.SportsCar;
import com.nt.comps.StandardCar;

public class CarFactory {
	
	  //static factory method  having  factory pattern class
	public  static ICar  getInstance(String type) {
		  ICar  car=null;
		if(type.equalsIgnoreCase("standard"))
			car=new StandardCar();
		else if(type.equalsIgnoreCase("luxory"))
			car=new  LuxoryCar();
		else  if(type.equalsIgnoreCase("sports"))
			car=new SportsCar();
		else
			throw  new IllegalArgumentException("Invalid CarType");
		
		return car;
	}

}
