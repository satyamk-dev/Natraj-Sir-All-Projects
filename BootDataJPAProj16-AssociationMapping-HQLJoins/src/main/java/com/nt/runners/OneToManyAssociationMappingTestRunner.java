package com.nt.runners;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.service.IContactDetailsMgmtService;

@Component
public class OneToManyAssociationMappingTestRunner implements CommandLineRunner {
	@Autowired
	private IContactDetailsMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		/*try {
			List<Object[]> list=service.showPersonAndPhoneNumbersData();
			list.forEach(row->{
				System.out.println(Arrays.toString(row));
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			List<Object[]> list=service.showPhoneNumberAndPersonData();
			list.forEach(row->{
				System.out.println(Arrays.toString(row));
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				
	}//main

}//class
