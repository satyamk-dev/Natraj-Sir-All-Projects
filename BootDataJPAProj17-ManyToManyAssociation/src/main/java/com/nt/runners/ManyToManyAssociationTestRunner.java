package com.nt.runners;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Faculty;
import com.nt.entity.Student;
import com.nt.service.ICollegeMgmtService;

@Component
public class ManyToManyAssociationTestRunner implements CommandLineRunner {

	@Autowired
	private ICollegeMgmtService  collegeService;


	@Override
	public void run(String... args) throws Exception {
		/*	try {
					//create parents
					Faculty  fac1=new Faculty("raja","hyd");
					Faculty  fac2=new Faculty("suresh","hyd");
					//create childs
					Student  stud1=new Student("ramesh","delhi");
					Student  stud2=new Student("lokesh","lucknow");
					Student  stud3=new Student("hareesh","mumbai");
					//add students to faculties (childs to parent)
					fac1.getStuds().add(stud1); fac1.getStuds().add(stud2);
					fac2.getStuds().add(stud1); fac2.getStuds().add(stud2); fac2.getStuds().add(stud3);
					//add  factulties  to  students
					stud1.getFactulties().add(fac1); stud1.getFactulties().add(fac2);
					stud2.getFactulties().add(fac1); stud2.getFactulties().add(fac2);
					stud3.getFactulties().add(fac2);
					
					//  add Faculties to List collection
					List<Faculty>  list=Arrays.asList(fac1,fac2);
					//invoke the method
					String   msg=collegeService.registerFacultiesAndTheirStudents(list);
					System.out.println(msg);
				}//try
				catch(Exception e) {
					e.printStackTrace();
				}
		*/
		
		/*try {
			//create parents
			Faculty  fac1=new Faculty("raja1","hyd");
			Faculty  fac2=new Faculty("suresh1","hyd");
			//create childs
			Student  stud1=new Student("ramesh1","delhi");
			Student  stud2=new Student("lokesh1","lucknow");
			Student  stud3=new Student("hareesh1","mumbai");
			//add students to faculties (childs to parent)
			fac1.getStuds().add(stud1); fac1.getStuds().add(stud2);
			fac2.getStuds().add(stud1);  fac2.getStuds().add(stud3);
			//add  factulties  to  students
			stud1.getFactulties().add(fac1); stud1.getFactulties().add(fac2);
			stud2.getFactulties().add(fac1); 
			stud3.getFactulties().add(fac2);
			
			//  add Students to List collection
			List<Student>  list=Arrays.asList(stud1,stud2,stud3);
			//invoke the method
			String   msg=collegeService.registerStudentsAndTheirFaculties(list);
			System.out.println(msg);
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			List<Faculty>  list=collegeService.showFacultiesAndTheirStudents();
			list.forEach(fac->{
				System.out.println("Faculty(parent)::"+fac);
				Set<Student>  childs=fac.getStuds();
				childs.forEach(st->{
					System.out.println("Student (child)::"+st);
				});
				System.out.println("---------------------");
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

		
	}//main

}//class
