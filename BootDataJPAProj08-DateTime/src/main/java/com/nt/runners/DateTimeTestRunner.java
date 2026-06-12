package com.nt.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Politician;
import com.nt.service.IPoliticianMgmtService;

@Component
public class DateTimeTestRunner implements CommandLineRunner {
	@Autowired
	private  IPoliticianMgmtService  service;

	@Override
	public void run(String... args) throws Exception {
		/*	try {
				Politician  plctn=new Politician("Rahul","INC",LocalDate.of(1980,11,21),
						                                                          LocalTime.of(11, 10), LocalDateTime.of(1999, 11, 12, 11, 15));
				String  msg=service.savePolitician(plctn);
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("================================");
			try {
				service.showAllPoliiticians().forEach(System.out::println);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		*/
		
		try {
			double  age=service.showPoliticianAgeById(2);
			System.out.println("Politician age ::"+age);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
