package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class BootMsProj13BillingMsProviderMsApplication {

	public static void main(String[] args) {
		log.debug("start of main(-) method -- BillingMS");
		SpringApplication.run(BootMsProj13BillingMsProviderMsApplication.class, args);
		log.debug("End of main(-) method -- BillingMS");
	}

}
