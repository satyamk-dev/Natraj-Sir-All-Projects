package com.nt;


import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBatchTestApplication {
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(SpringBootBatchTestApplication.class, args);
	}

}
