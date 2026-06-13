package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableAdminServer
@Slf4j
public class BootMsProj13AdminServerApplication {

	public static void main(String[] args) {
		log.debug("Start  of the App --  Admin server");
		SpringApplication.run(BootMsProj13AdminServerApplication.class, args);
		log.debug("End  of the App --  Admin server");
	}

}
