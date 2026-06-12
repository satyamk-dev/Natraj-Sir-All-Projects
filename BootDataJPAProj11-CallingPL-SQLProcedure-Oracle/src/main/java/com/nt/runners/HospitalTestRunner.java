package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Hospital;
import com.nt.service.IHospitalMgmtService;

@Component
public class HospitalTestRunner implements CommandLineRunner {
	@Autowired
	private IHospitalMgmtService  hsService;

	@Override
	public void run(String... args) throws Exception {
		try {
			List<Hospital>  list=hsService.showHospitalsBySize(2000, 6000);
			list.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
