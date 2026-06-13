package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class BootMsProj14EurekaServerApplication {

	public static void main(String[] args) {
		log.debug("Start of  Eureka server");
		SpringApplication.run(BootMsProj14EurekaServerApplication.class, args);
	   log.debug("End of Eureka server");
	}

}
