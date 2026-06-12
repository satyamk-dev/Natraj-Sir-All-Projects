package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.CollegeDetails;

@SpringBootApplication
public class BootIocProj13BulkInjectionApplication {

	public static void main(String[] args) {
		try(ConfigurableApplicationContext ctx=
				     SpringApplication.run(BootIocProj13BulkInjectionApplication.class, args);){
			//get  spring bean class obj ref
			CollegeDetails  details=ctx.getBean("college",CollegeDetails.class);
			System.out.println(details);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
