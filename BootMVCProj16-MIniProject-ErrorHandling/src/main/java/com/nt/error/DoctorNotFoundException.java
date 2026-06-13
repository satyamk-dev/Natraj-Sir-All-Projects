package com.nt.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY)
public class DoctorNotFoundException extends RuntimeException {
	
	public DoctorNotFoundException(String msg) {
		super(msg);
	}

}
