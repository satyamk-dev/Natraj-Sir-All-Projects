//WeekDayAnalyzer.java
package com.nt.sbeans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("wda")
public class WeekDayAnalyzer {
	@Autowired
	@Qualifier("ldate")
	private  LocalDate   date; //HAS-A property
	
	@Autowired
	private   LocalTime  time;// HAS- A property
	
	
	private   WeekDayAnalyzer() {
		System.out.println("WeekDayAnalyzer:: 0-param constructor");
	}

	/*@Autowired
	public WeekDayAnalyzer(@Qualifier("ldate2")LocalDate date ,LocalTime time) {
		this.time=time;
		this.date=date;
		System.out.println("WeekDayAnalyzer:: 2-param constructor");
	}*/
	
	
	
	
	@Autowired
	@Qualifier("ldate1")
	private void  putDate(LocalDate  date) {
		System.out.println("WeekDayAnalyzer.putDate()");
		this.date=date;
	}
	
	@Autowired
	@Qualifier("ldate3")
	private  void  setDate(LocalDate  date) {
		System.out.println("WeekDayAnalyzer.setDate()");
		this.date=date;
	}
	
	
	/*@Autowired
	public void  assignTime(LocalTime time) {
		System.out.println("WeekDayAnalyzer.assignTime()");
		this.time=time;
	}*/
	
	
	/*//@Autowired
	public WeekDayAnalyzer(LocalDate date) {
		this.date=date;
		System.out.println("WeekDayAnalyzer:: 1-param constructor");
	}*/
	
	
	/*public WeekDayAnalyzer() {
		System.out.println("WeekDayAnalyzer:: 0-param constructor");
	}*/
	
		
	/*	@Autowired
		public  void  setTime(LocalTime time) {
			this.time=time;
		}*/
	
	//b.method
	public  String   generateWorkMessage(String user) {
		System.out.println("WeekDayAnalyzer.generateWorkMessage()::"+date+"....."+time);
		//get current weekday number
		int wno=date.getDayOfWeek().getValue();
		//generate the message
		if(wno>=1 && wno<=5)
			return "Happy Working Day::"+user;
		else
			return "Enjoy WeekEnd::"+user;
	}
	

}
