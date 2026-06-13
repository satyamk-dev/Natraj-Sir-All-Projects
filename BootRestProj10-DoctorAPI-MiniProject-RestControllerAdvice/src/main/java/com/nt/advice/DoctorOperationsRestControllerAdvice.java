package com.nt.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.exceptions.DoctorNotFoundException;

@RestControllerAdvice
public class DoctorOperationsRestControllerAdvice {
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public   ResponseEntity<ErrorDetails> handleDNFE(DoctorNotFoundException dnfe){
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(), dnfe.getMessage(), "500-Doctor not found");
		return new  ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public   ResponseEntity<ErrorDetails> handleAllExceptions(Exception e){
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(), e.getMessage(), "500-Internal probel");
		return new  ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
