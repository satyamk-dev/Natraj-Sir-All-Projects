package com.nt.sbeans;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportGenerator {
	
	//@Scheduled(initialDelay = 3000,fixedDelay = 5000)
	//@Scheduled(fixedDelay = 5000)
	//@Scheduled(fixedDelayString =  "5000")
	//@Scheduled(initialDelay =  3000)
	//@Scheduled(fixedDelay = 3000)
	@Scheduled(fixedRate = 5000)
	public   void    showReport()throws Exception {
		System.out.println("Thread name(task1) ::"+Thread.currentThread());
				System.out.println("Report is on  ::"+new Date() +"(start)");
				Thread.sleep(10000);
				System.out.println("Report is on  ::"+new Date() +"(end)");
				System.out.println("----------------------------");
				
	}
	
	/*@Scheduled(fixedDelay = 2000)
	public   void    showReport1()throws Exception {
		System.out.println("Thread name(task2) ::"+Thread.currentThread());
				System.out.println("Report1 is on  ::"+new Date() +"(start)");
				Thread.sleep(10000);
				System.out.println("Report1 is on  ::"+new Date() +"(end)");
				
	}*/


}
