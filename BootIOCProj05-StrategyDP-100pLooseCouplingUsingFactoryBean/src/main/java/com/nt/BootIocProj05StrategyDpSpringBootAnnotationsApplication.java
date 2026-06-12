package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
public class BootIocProj05StrategyDpSpringBootAnnotationsApplication {

	public static void main(String[] args) {
		try(ConfigurableApplicationContext ctx=
				    SpringApplication.run(BootIocProj05StrategyDpSpringBootAnnotationsApplication.class, args)){
			//get target spring bean class obj ref
			  Vehicle  vehicle=ctx.getBean("vehicle",Vehicle.class);
			  vehicle.journey("hyd", "goa");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
