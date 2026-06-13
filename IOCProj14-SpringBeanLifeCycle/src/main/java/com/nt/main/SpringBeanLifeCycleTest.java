package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.Voter;

public class SpringBeanLifeCycleTest {

	public static void main(String[] args) {
		//create  IOC container
	  try(AnnotationConfigApplicationContext  ctx=
			       new AnnotationConfigApplicationContext(AppConfig.class)){
		  //get Spring Bean class obj ref
		  Voter  voter=ctx.getBean("voter",Voter.class);
		  System.out.println(voter.checkVotingElgibility());
		  
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }

	}

}
