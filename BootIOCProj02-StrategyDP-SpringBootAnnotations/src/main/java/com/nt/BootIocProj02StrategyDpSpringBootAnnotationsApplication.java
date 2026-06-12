package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
public class BootIocProj02StrategyDpSpringBootAnnotationsApplication {

	public static void main(String[] args) {
		try(ConfigurableApplicationContext ctx=
				    SpringApplication.run(BootIocProj02StrategyDpSpringBootAnnotationsApplication.class, args)){
			//get target spring bean class obj ref
			  Vehicle  vehicle=ctx.getBean("vehicle",Vehicle.class);
			  vehicle.journey("hyd", "goa");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
