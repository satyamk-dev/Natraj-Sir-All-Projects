package com.nt.runners;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.StudentInfo;
import com.nt.service.IStudentMgmtService;

@Component
public class ColllectionMappingTestRunner implements CommandLineRunner {
	@Autowired
	private IStudentMgmtService  studService;

	@Override
	public void run(String... args) throws Exception {
       try {
    	   StudentInfo info=new StudentInfo("raja", "hyd", List.of("red","green","blue"),
    			                                                                                      Set.of(999999L,888888L,9999999L),
    			                                                                                      Map.of("aadhar","4A5545455", "voter id","5A454545"));
    	     String  msg=studService.registerStudent(info);
    	     System.out.println(msg);
    	    }
       catch(Exception e) {
    	   e.printStackTrace();
       }


	}

}
