package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Student;
import com.nt.service.IStudentMgmtService;

@Component
public class InMemoryDBTest implements CommandLineRunner {
	@Autowired
	private IStudentMgmtService  studService;

	@Override
	public void run(String... args) throws Exception {
		try {
			Student st=new Student("rajesh","hyd",67.9f);
			String msg=studService.saveStudent(st);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("=================");
		
		try {
			studService.showAllStudents().forEach(System.out::println);
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("======================");
		System.out.println("Press any key  to continue");
		System.in.read();
		System.exit(0);
	}

}
