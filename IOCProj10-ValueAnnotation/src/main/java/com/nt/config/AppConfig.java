//AppConfig.java
package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"com/nt/commons/Info1.properties","com/nt/commons/Info.properties" })
@ComponentScan(basePackages = "com.nt.sbeans")
public class AppConfig {

}
