package com.nt.main;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import com.nt.config.AppConfig;

public class ReflectionAPITest1 {

	public static void main(String[] args) throws Exception{
		
		//create  object of java.lang.Class
		 Class clazz=AppConfig.class;
		 System.out.println("class name ::"+clazz.getName());
		 System.out.println("super class name ::"+clazz.getSuperclass().getName());
		 System.out.println("List of implemented interfaces ::"+Arrays.toString(clazz.getInterfaces()));
		 System.out.println("List of methods  ::"+Arrays.toString(clazz.getDeclaredMethods()));
		 System.out.println("List of fields  ::"+Arrays.toString(clazz.getDeclaredFields()));
			 
				

	}

}
