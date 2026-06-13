package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class BootMsProj14CloudApiGatewayMiniProjectApp {

	public static void main(String[] args) {
		log.debug("start of  main(-) in Cloud API Gateway ");
		SpringApplication.run(BootMsProj14CloudApiGatewayMiniProjectApp.class, args);
		log.debug("End of  main(-) in Cloud API Gateway ");
	}

}
