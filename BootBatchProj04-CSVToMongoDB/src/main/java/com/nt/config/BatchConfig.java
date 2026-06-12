package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import com.nt.document.ExamResult;
import com.nt.listener.JobMonitoringListener;
import com.nt.processor.ExamResultItemProcessor;

@Configuration
public class BatchConfig {
	@Autowired
	private  ExamResultItemProcessor  processor;
	@Autowired
	private  JobMonitoringListener  listener;
	@Autowired
	private  MongoTemplate template;
	
	@Bean(name="jciReader")
	public   FlatFileItemReader<ExamResult>  createReader(){
		  return new FlatFileItemReaderBuilder<ExamResult>()
				                     .name("reader")
				                     .resource(new FileSystemResource("TopResults.csv"))
				                     .delimited().delimiter(",")
				                     .names("id","dob","percentage","semester")
				                     .targetType(ExamResult.class)
				                     .build();
	}
	
	
	@Bean(name="ffWriter")
	public   MongoItemWriter<ExamResult>  createWriter(){
		return   new  MongoItemWriterBuilder<ExamResult>()
				                 .collection("SuperBrains")
				                 .template(template)
				                 .build();
				                
				                 
				                 
				              	}
	
	@Bean(name="step1")
	public  Step  createStep1(JobRepository jobRepo,PlatformTransactionManager  txMgmr) {
		 return  new StepBuilder("step1",jobRepo)
				                                     .<ExamResult,ExamResult>chunk(10,txMgmr)
				                                     .reader(createReader())
				                                     .writer(createWriter())
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
