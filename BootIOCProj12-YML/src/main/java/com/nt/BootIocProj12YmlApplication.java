package com.nt;

import java.beans.Customizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.CustomerInfo;

@SpringBootApplication
public class BootIocProj12YmlApplication {

	public static void main(String[] args) {
		  //get  IOC container
		try(ConfigurableApplicationContext ctx=SpringApplication.run(BootIocProj12YmlApplication.class, args);){
			
			//get spring bean class obj ref
			CustomerInfo info=ctx.getBean("custInfo",CustomerInfo.class);
			System.out.println(info);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
