package com.nt.runners;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

//@Component
public class SpringBootBatchTestRunner implements CommandLineRunner {
	@Autowired
	private  JobLauncher launcher;
	@Autowired
	private    Job job;

	public void run(String args[])throws Exception {
		 //prepare job params
		JobParameters params=new JobParametersBuilder().addLong("systime", System.currentTimeMillis()).toJobParameters();
		//run the job
		JobExecution  execution= launcher.run(job, params);
		System.out.println("Job Execution status ::"+execution.getExitStatus());
	   //System.exit(0);
		
	}

}
