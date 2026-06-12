package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.nt.entity.PersonEntity;
import com.nt.listener.JobMonitoringListener;
import com.nt.processor.PersonalInfoItemProcessor;
import com.nt.repository.IPersonalInfoRepository;

@Configuration
public class BatchConfig {
	@Autowired
	private  PersonalInfoItemProcessor  processor;
	@Autowired
	private  JobMonitoringListener  listener;
	@Autowired
	private  IPersonalInfoRepository  pInfoRepo;
	
	@Bean(name="ffReader")
	public   FlatFileItemReader<PersonEntity>  createReader(){
		  return new FlatFileItemReaderBuilder<PersonEntity>()
				          .name("ffReader")
				          .resource(new ClassPathResource("Personal_Info.csv"))
				          .delimited()
				          .names("pid","firstName","lastName","salary")
				          .targetType(PersonEntity.class)
				          .build();
	}
	
	@Bean(name="ffWriter")
	public   RepositoryItemWriter<PersonEntity>  createWriter(){
		return   new  RepositoryItemWriterBuilder<PersonEntity>()
				                  .repository(pInfoRepo)
				                  .methodName("save")
				                  .build();
	}
	
	@Bean(name="step1")
	public  Step  createStep1(JobRepository jobRepo,PlatformTransactionManager  txMgmr) {
		 return  new StepBuilder("step1",jobRepo)
				                                     .<PersonEntity,PersonEntity>chunk(2,txMgmr)
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
