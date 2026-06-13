//WishMessGenerator.java (target spring bean class)
package com.nt.sbeans;

import java.time.LocalTime;

public class WishMessageGenerator {
    //HAS-A  property
	 private  LocalTime  time;  //composition
	  // simple property
	 private    int age;
	 
	 
	 public WishMessageGenerator() {
		System.out.println("WishMessageGenerator:: 0-param constructor");
	}
	 
		 public WishMessageGenerator(LocalTime time,int age) {
			 this.time=time;
			 this.age=age;
			System.out.println("WishMessageGenerator::2-param constructor");
		}
	 
	//setter method for  setter injection
	public  void setTime(LocalTime time) {
	 System.out.println("WishMessageGenerator.setTime()");
	 this.time=time;
	}
	public  void  setAge(int age) {
		System.out.println("WishMessageGenerator.setAge()");
		this.age=age;
	}
	 
	 //b.method
	 public  String   generateWishMessage(String user) {
		 System.out.println("WishMessageGenerator.generateWishMessage()::"+time+"...."+age);
		 // get  current hour of the day
		   int  hour=time.getHour();
		   //generate wish message
		   if(hour<12)
			   return "Good Morning:"+user;
		   else if(hour<16)
			   return  "Good Afternoon:"+user;
		   else if(hour<20)
			   return "Good Evening:"+user;
		   else 
			   return "Good Night:"+user;
	 }
	  
}
