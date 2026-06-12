//OptionalAPITest.java
package com.nt.core;

import java.util.Date;

public class OptionalAPITest {
	
	public  Date prepareDate(int year,int month ,int day) {
		   if(year>0 && month>0 && day>0)
			   return  new  Date(year,month,day);
		   else 
			   return  null;
	}

	public static void main(String[] args) {
		OptionalAPITest  test=new  OptionalAPITest();
		Date  d=test.prepareDate(2000, -10, 20);
		System.out.println(d.toString());

	}

}
