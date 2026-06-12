//OptionalAPITest.java
package com.nt.core;

import java.util.Date;
import java.util.Optional;

public class OptionalAPITest1 {
	
	public  Optional<Date> prepareDate(int year,int month ,int day) {
		   if(year>0 && month>0 && day>0)
			   return  Optional.of(new Date(year,month,day));
		   else 
			   return  Optional.empty();
	}

	public static void main(String[] args) {
		OptionalAPITest1  test=new  OptionalAPITest1();
		Optional<Date> opt=test.prepareDate(2000, 10, -20);
		if(opt.isPresent()) {
		  Date  d=opt.get();
		  System.out.println(d.toString());
		}
		else {
			System.out.println("Wrong date is given");
		}
			

	}

}
