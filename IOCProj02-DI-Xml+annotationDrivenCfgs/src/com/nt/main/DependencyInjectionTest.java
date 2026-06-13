package com.nt.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.sbeans.SeasonFinder;

public class DependencyInjectionTest {

	public static void main(String[] args) {
		//create  IOC container
		FileSystemXmlApplicationContext  ctx=
				                  new  FileSystemXmlApplicationContext("src/com/nt/cfgs/applicationContext.xml");
		//get  target spring bean class obj ref
		SeasonFinder  finder=(SeasonFinder)ctx.getBean("sf");
		//invoke the b.method
		String result=finder.showSeasonName();
		System.out.println("Season name::"+result);
		//close the IOC container
		 ctx.close();

	}//main

}//class
