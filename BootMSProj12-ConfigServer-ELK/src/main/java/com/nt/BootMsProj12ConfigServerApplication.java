package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableConfigServer
@Slf4j
public class BootMsProj12ConfigServerApplication {

	public static void main(String[] args) {
		log.debug("start of  main(-) method --config server");
		SpringApplication.run(BootMsProj12ConfigServerApplication.class, args);
		log.debug("end of  main(-) method --config server");
	}

}
