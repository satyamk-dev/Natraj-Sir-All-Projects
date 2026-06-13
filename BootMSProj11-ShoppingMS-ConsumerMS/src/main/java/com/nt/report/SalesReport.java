package com.nt.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class SalesReport {
	
	@Scheduled(cron="0 * * * * *")
	public  void  showReport() {
		System.out.println("Sales Report on ::"+new Date());
	}

}
