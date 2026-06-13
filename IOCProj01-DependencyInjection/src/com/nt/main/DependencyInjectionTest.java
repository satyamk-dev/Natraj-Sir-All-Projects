//DependentInjectionTest.java
//===========================
package com.nt.main;

import java.util.Arrays;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.sbeans.WishMessageGenerator;
import com.nt.ston.Printer;

public class DependencyInjectionTest {

	public static void main(String[] args) {
		//create  ApplicationContext  IOC container
		FileSystemXmlApplicationContext ctx=
				new FileSystemXmlApplicationContext("src/com/nt/cfgs/applicationContext.xml");
		/*//get target spring bean class obj ref
		Object obj=ctx.getBean("wmg");
		Object obj1=ctx.getBean("wmg");  
		System.out.println(obj.hashCode()+"..."+obj1.hashCode());
		//type casting
		WishMessageGenerator  generator=(WishMessageGenerator) obj;
		//invoke the b.method
		String  msg=generator.generateWishMessage("raja");
		System.out.println(msg);
		System.out.println("=================");
		Object obj2=ctx.getBean("wmg1");
		Object obj22=ctx.getBean("wmg1");  
		System.out.println(obj2.hashCode()+"..."+obj22.hashCode());
		System.out.println("=================");
		*/	
		System.out.println("Spring Beans count::"+ctx.getBeanDefinitionCount());
		System.out.println("Spring Bean ids ::"+Arrays.toString(ctx.getBeanDefinitionNames()));
		System.out.println("=================");
			
		/*Printer p1=ctx.getBean("prn1",Printer.class);
		Printer p2=ctx.getBean("prn2",Printer.class);
		System.out.println(p1.hashCode()+"  "+p2.hashCode());
		System.out.println("p1==p2?"+(p1==p2));
		*/
	
		
		//close  the IOC container
		ctx.close();

	}

}
