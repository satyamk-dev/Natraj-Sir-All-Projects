package com.nt.listener;

import java.util.Date;

import org.springframework.batch.core.job.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component("jmr")
public class JobMonitoringListener implements JobExecutionListener {
	private  long startTime , endTime;

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("JobMonitoringListener.beforeJob() :: Job Started at ::"+new Date());
		startTime=System.currentTimeMillis();
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
         System.out.println("JobMonitoringListener.afterJob() :: Job Ended at ::"+new Date());
         endTime=System.currentTimeMillis();
         System.out.println("Job is executed for "+(endTime-startTime)+" ms");
	}

}
