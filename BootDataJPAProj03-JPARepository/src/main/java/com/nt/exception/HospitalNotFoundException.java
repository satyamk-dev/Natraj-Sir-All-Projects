package com.nt.exception;

public class HospitalNotFoundException extends RuntimeException {
	
	  public HospitalNotFoundException() {
		 super();
	}
	  
	  
	  public HospitalNotFoundException(String msg) {
			 super(msg);
		}

	  
}
