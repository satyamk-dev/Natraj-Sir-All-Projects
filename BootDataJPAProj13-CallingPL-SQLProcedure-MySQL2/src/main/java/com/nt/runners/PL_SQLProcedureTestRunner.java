package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ILoginMgmtService;

@Component
public class PL_SQLProcedureTestRunner implements CommandLineRunner {
	@Autowired
	private ILoginMgmtService  service;

	@Override
	public void run(String... args) throws Exception {
		try {
			  String result=service.login("raja", "rani1");
			  System.out.println(result);
	}
   catch(Exception e) {
	   e.printStackTrace();
   }

	}

}
