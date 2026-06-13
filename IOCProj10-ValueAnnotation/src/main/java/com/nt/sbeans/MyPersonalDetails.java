package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("myPInfo")
public class MyPersonalDetails {
	@Autowired
	private   Environment  env;
	
	
	public  String  toString() {
		return  env.getProperty("per.id")+"...."+env.getProperty("os.name");
	}

}
