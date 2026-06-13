package com.nt.main;

import java.lang.reflect.Constructor;

public class ReflectionAPITest {

	public static void main(String[] args) throws Exception{
		
		//load  the class
		Class clazz=Class.forName("com.nt.sbeans.WeekDayAnalyzer");
		//get  all the constructors
		Constructor cons[]=clazz.getDeclaredConstructors();
		//get access to private constructor
		cons[0].setAccessible(true);
		//  create the object
		Object obj=cons[0].newInstance();
		System.out.println(obj.hashCode()+"...."+obj.getClass());
		

	}

}
