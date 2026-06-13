package com.nt.sbeans;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportGenerator {
	
	//@Scheduled(cron="20 * * * * *")
	//@Scheduled(cron="10 31 * * *  *")
	//@Scheduled(cron="0 0 9  15 8 *")
	//@Scheduled(cron="0  0  0 1 1 *")
	//@Scheduled(cron="0 36-39 * * * * ")
	//@Scheduled(cron="10 39,41,42 * * * * ")
	//@Scheduled(cron="0  44 12 *  * SAT")
	//@Scheduled(cron="0 46 12  *  * SUN,SAT")
	//@Scheduled(cron="0 30 11  *  * 0-4 ")
	//@Scheduled(cron="0/20 * * * * * ")
	//@Scheduled(cron="0/40 * * * * * ")
	//@Scheduled(cron="0/20  0/3 * * * * ")
	//@Scheduled(cron="0  6/10  1/2 * * * ")
	//@Scheduled(cron="@hourly")
	//@Scheduled(cron="0  15  12 L-20 *  *")
	//@Scheduled(cron="0  19  12 * *  MON#2")
	@Scheduled(cron="0  26 12 11W  * * ")
	public   void    showReport()throws Exception {
		System.out.println("Thread name(task1) ::"+Thread.currentThread());
				System.out.println("Report is on  ::"+new Date());
	}
	
	/*@Scheduled(fixedDelay = 2000)
	public   void    showReport1()throws Exception {
		System.out.println("Thread name(task2) ::"+Thread.currentThread());
				System.out.println("Report1 is on  ::"+new Date() +"(start)");
				Thread.sleep(10000);
				System.out.println("Report1 is on  ::"+new Date() +"(end)");
				
	}*/


}
