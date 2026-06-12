package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.nt.entity.ExamResult;
import com.nt.listener.JobMonitoringListener;
import com.nt.processor.ExamResultItemProcessor;

@Configuration
public class BatchConfig {
	@Autowired
	private  ExamResultItemProcessor  processor;
	@Autowired
	private  JobMonitoringListener  listener;
	@Autowired
	private  DataSource  ds;
	
	@Bean(name="jciReader")
	public   JdbcCursorItemReader<ExamResult>  createReader(){
		  return new JdbcCursorItemReaderBuilder<ExamResult>()
				                     .name("reader")
				                     .dataSource(ds)
				                     .sql("SELECT * FROM EXAM_RESULT")
				                     .beanRowMapper(ExamResult.class)
				                     .build();
	}
	
	
	@Bean(name="ffWriter")
	public   FlatFileItemWriter<ExamResult>  createWriter(){
		return   new  FlatFileItemWriterBuilder<ExamResult>()
				                 .name("writer")
				                 .resource(new FileSystemResource("TopResults.csv"))
				                 .lineSeparator("\r\n")
				                 .delimited().delimiter(",")
				                 .names("id","dob","percentage","semester")
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
