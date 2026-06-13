//StrategyDPTest.java
package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.Cricketer;

public class StrategyDPTest {

	public static void main(String[] args) {
		   //create  IOC container
		try(AnnotationConfigApplicationContext ctx=
				 new AnnotationConfigApplicationContext(AppConfig.class)){
			//get target spring bean class object ref
			  Cricketer  cktr1=ctx.getBean("cktr",Cricketer.class);
			  //call the b.method
			  String result=cktr1.batting("rohit");
			  System.out.println("result is ::"+result);
					}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
