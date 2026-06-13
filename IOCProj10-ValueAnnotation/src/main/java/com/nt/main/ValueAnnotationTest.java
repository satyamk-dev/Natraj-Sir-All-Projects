package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.nt.config.AppConfig;
import com.nt.sbeans.MyPersonalDetails;
import com.nt.sbeans.PersonInfo;

public class ValueAnnotationTest {

	public static void main(String[] args) {
		//create IOC container
		try(AnnotationConfigApplicationContext  ctx=
				  new AnnotationConfigApplicationContext(AppConfig.class)){
			//get spring Bean class obj ref
			PersonInfo info=ctx.getBean("pInfo",PersonInfo.class);
			System.out.println(info);
			System.out.println("===============");
			Environment  env=ctx.getEnvironment();
			System.out.println("os.name  is ::"+env.getProperty("os.name"));
			System.out.println("per.name is ::"+env.getProperty("per.name"));
			System.out.println("env obj class name ::"+env.getClass());
			System.out.println("==================");
			MyPersonalDetails  details=ctx.getBean("myPInfo",MyPersonalDetails.class);
			System.out.println(details);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
