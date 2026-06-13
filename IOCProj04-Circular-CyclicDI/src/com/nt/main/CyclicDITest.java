//CyclicDITest.java
package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.A;
import com.nt.sbeans.B;

public class CyclicDITest {

	public static void main(String[] args) {
		//create  IOC container
		AnnotationConfigApplicationContext ctx=
				  new AnnotationConfigApplicationContext(AppConfig.class);
		//get Spring Bean class obj ref
		A  a1=ctx.getBean("a1",A.class);
		System.out.println(a1);
		System.out.println("-----------------");
		
		  B   b1=ctx.getBean("b1",B.class);
		System.out.println(b1);
		System.out.println("-----------------");
		}

}
