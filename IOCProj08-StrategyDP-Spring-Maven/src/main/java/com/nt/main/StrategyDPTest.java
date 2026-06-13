//StrategyDPTest.java
package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.Cricketer;
import com.nt.ston.Printer;

public class StrategyDPTest {

	public static void main(String[] args) {
		   //create  IOC container
		try(AnnotationConfigApplicationContext ctx=
				 new AnnotationConfigApplicationContext(AppConfig.class)){
			//get target spring bean class object ref
			  Cricketer  cktr1=ctx.getBean("cktr",Cricketer.class);
			  Cricketer  cktr2=ctx.getBean("cktr",Cricketer.class);
			  System.out.println(cktr1.hashCode()+" ...."+cktr2.hashCode());
			  System.out.println("cktr1==cktr2?"+(cktr1==cktr2));
			  
			  System.out.println("=======================");
			  Printer p1=ctx.getBean("prn",Printer.class);
			  Printer p2=ctx.getBean("prn",Printer.class);
			  System.out.println(p1.hashCode()+"..."+p2.hashCode());
			  
			  
					}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
