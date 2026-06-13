package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
@Slf4j
public class BootMsProj13ShoppingMsConsumerMsLbcApplication {

	public static void main(String[] args) {
		log.debug("start of main(-)  shoppingMS");
		SpringApplication.run(BootMsProj13ShoppingMsConsumerMsLbcApplication.class, args);
		log.debug("end of main(-)  shoppingMS");
	}

}
