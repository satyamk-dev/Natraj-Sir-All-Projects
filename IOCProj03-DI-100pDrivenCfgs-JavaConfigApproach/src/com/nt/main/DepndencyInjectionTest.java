//DependencyInjectionTest.java
package com.nt.main;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.WeekDayAnalyzer;

public class DepndencyInjectionTest {

	public static void main(String[] args) {
		
		// create  IOC container
		try(AnnotationConfigApplicationContext  ctx=
				        new   AnnotationConfigApplicationContext(AppConfig.class)){
		//get target spring bean class obj ref
		//WeekDayAnalyzer  wda=ctx.getBean("wda",WeekDayAnalyzer.class);
			  Class<WeekDayAnalyzer>  clazz=WeekDayAnalyzer.class;
			  WeekDayAnalyzer wda=ctx.getBean("wda",clazz);
		//invoke the b.method
		 String result=wda.generateWorkMessage("raja");
		System.out.println("result is ::"+result);
		System.out.println("=================");
		
		}//try-  Here itself the IOC container will be closed automatically
		
		catch(Exception e) {
			e.printStackTrace();
		}
	
         	}

}
