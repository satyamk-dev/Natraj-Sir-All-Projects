package com.nt.runners;


import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.JobExecution;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

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
