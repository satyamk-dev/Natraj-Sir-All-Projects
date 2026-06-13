package com.nt.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("voter")
public class Voter {
	@Value("${voter.name}")
	private  String  name;
	@Value("${voter.age}")
	private  int age;
	private  LocalDate dov;
	
	static {
		System.out.println("Voter::static method");
	}
	
	public Voter() {
		System.out.println("Voter:: 0-param constructor");
	}
	
	
	
	@PostConstruct
	public  void myInit() {
	 System.out.println("Voter.myInit()");
	   //initialize left over properties
	   dov=LocalDate.now();
	   //check weather import properties are injected with correct values or not
	   if(name==null ||  name.equals("") ||name.length()==0 || age<0)
		throw new IllegalArgumentException("Invalid  inputs");   
	}

	  public   String checkVotingElgibility() {
		  System.out.println("Voter.checkVotingElgibility()");
		  if(age<18)
			  return "Mr/Miss/Mrs."+name+" u r not elgible to vote ---verified on::"+dov;
		  else
			  return "Mr/Miss/Mrs."+name+" u r  elgible to vote--- verified on ::"+dov;
	  }
	  
	  @PreDestroy
	  public   void  myDestroy() {
		  System.out.println("Voter.myDestroy()");
		  name=null;
		  age=0;
		  dov=null;
	  }
}
