package com.nt;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootIocProj01DependencyMgmtApplication {
	
	public BootIocProj01DependencyMgmtApplication() {
		System.out.println("BootIocProj01DependencyMgmtApplication:: 0-param constructor");
	}
	
	//pre-defined class as spring bean
	@Bean(name="dt")
	public    LocalDate  createDate() {
		System.out.println("BootIocProj01DependencyMgmtApplication.createDate()");
		return  LocalDate.now();
	}

	public static void main(String[] args) {
		 //create  IOC container
		try(ConfigurableApplicationContext ctx=
				         SpringApplication.run(BootIocProj01DependencyMgmtApplication.class, args)){
			//get  target spring bean class obj ref
			SeasonFinder  finder=ctx.getBean("sf",SeasonFinder.class);
			System.out.println("Season name::"+finder.showSeason());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
