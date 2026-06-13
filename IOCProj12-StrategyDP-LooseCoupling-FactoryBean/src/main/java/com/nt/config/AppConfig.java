//AppConfig.java
package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;


@Configuration
@ComponentScan(basePackages = {"com.nt.sbeans","com.nt.factory"})
@PropertySource("com/nt/commons/Info.properties")
public class AppConfig {
	
	
}
