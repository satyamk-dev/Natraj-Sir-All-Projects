//AppConfig.java
package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.nt.ston.Printer;

@Configuration
@ComponentScan(basePackages = {"com.nt.sbeans"})
@ComponentScan(basePackages = {"com.nt.ston"})

public class AppConfig {
	
	@Bean(name="prn")
	//@Bean
	@Scope("prototype")
	public  Printer  getPrinter() {
		return Printer.getInstance();
	}

}
