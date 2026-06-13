package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class BootMsProj14lPlayerServiceApplication {

	public static void main(String[] args) {
		log.debug("start of main(-) method in IPLPlayerEntity service");
		SpringApplication.run(BootMsProj14lPlayerServiceApplication.class, args);
		log.debug("end of main(-) method in IPLPlayerEntity service");
		
	}

}
