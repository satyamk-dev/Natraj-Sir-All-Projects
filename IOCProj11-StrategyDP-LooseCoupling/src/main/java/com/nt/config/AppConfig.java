//AppConfig.java
package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;


@Configuration
@ComponentScan(basePackages = {"com.nt.sbeans"})
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class AppConfig {
	
	
}
