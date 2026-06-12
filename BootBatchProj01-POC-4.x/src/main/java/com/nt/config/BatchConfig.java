package com.nt.config;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.parameters.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.nt.listener.JobMonitoringListener;
import com.nt.processor.BookItemProcessor;
import com.nt.reader.BookItemReader;
import com.nt.writer.BookItemWriter;

@Configuration
public class BatchConfig {
	@Autowired
   private  BookItemReader  reader;
	@Autowired
	   private  BookItemWriter  writer;
	@Autowired
	private  BookItemProcessor  processor;
	@Autowired
	private  JobMonitoringListener  listener;
	
	@Bean(name="step1")
	public  Step  createStep1(JobRepository jobRepo) {
		 return  new StepBuilder("step1",jobRepo)
				                                     .<String,String>chunk(2)
				                                     .reader(reader)
				                                     .writer(writer)
				                                     .processor(processor)
				                                     .build();
				                                     
				                 
				 
	}
	
	@Bean(name="job1")
	public  Job  createJob1(JobRepository jobRepo,Step step1) {
		return new  JobBuilder("job1", jobRepo)
				               .listener(listener)
				                .incrementer(new RunIdIncrementer())
				               .start(step1)
				               .build();
	

	}
	
		
}
