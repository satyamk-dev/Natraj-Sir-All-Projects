//DefaultBeanIdsTest.java
package com.nt.main;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.Cricketer;
import com.nt.ston.Printer;

public class DefaultBeanIdsTest {

	public static void main(String[] args) {
		   //create  IOC container
		try(AnnotationConfigApplicationContext ctx=
				 new AnnotationConfigApplicationContext(AppConfig.class)){
			
			System.out.println("Spring Bean count::"+ctx.getBeanDefinitionCount());
			System.out.println("Bean ids ::"+Arrays.toString(ctx.getBeanDefinitionNames()));
			
			Printer  p1=ctx.getBean("getPrinter",Printer.class);
			System.out.println(p1.hashCode());
			  System.out.println("================");
			  Cricketer  cktr=ctx.getBean("cktr",Cricketer.class);
			  System.out.println(cktr.batting("raja"));
			  
					}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
