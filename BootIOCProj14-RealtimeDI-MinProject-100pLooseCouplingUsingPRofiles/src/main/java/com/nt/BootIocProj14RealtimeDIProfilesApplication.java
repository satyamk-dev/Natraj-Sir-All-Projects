package com.nt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.nt.controller.EmployeeOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootIocProj14RealtimeDIProfilesApplication {

	public static void main(String[] args) {
		System.out.println("BootIocProj07RealtimeDiMinProjectLayeredAppApplication.main() (start)");
		//create  IOC container
		try(ConfigurableApplicationContext ctx=
				           SpringApplication.run(BootIocProj14RealtimeDIProfilesApplication.class, args);
				Scanner sc=new Scanner(System.in);){
			
			 Environment env=ctx.getEnvironment();
			 System.out.println("The active profile name ::"+Arrays.toString(env.getActiveProfiles()));
		
			
			  //read inputs from enduser
			System.out.println("Enter  desg1::");
			String desg1=sc.next();
			
			System.out.println("Enter  desg2::");
			String desg2=sc.next();
			
			System.out.println("Enter  desg3::");
			String desg3=sc.next();
			
			//get Controller  Spring Bean class obj ref
			 EmployeeOperationsController controller=  ctx.getBean("empController",EmployeeOperationsController.class);
			 //invoke the b.method
			 List<Employee> list=controller.processEmployeeDesgs(desg1,desg2,desg3);
			 if(list.size()!=0) {
			   System.out.println("Employees having CLERK,MANAGER,SALESMAN Desgs are::");
			   list.forEach(System.out::println);
			 }
			 else
				 System.out.println("Records not  found");
			 
			 System.out.println("==========================================");
			 System.out.println("Enter  Employee  name::");
			 String name=sc.next();
			 System.out.println("Enter Employee desg::");
			 String  desg=sc.next();
			 System.out.println("Enter   Employee salary::");
			 float salary=sc.nextFloat();
			 //create Employee class obj
			 Employee  emp=new Employee();
			 emp.setEname(name); emp.setDesg(desg); emp.setSalary(salary);
			 //invoke the b.method
			 String msg=controller.saveEmployeeDetails(emp);
			 System.out.println(msg);
			 System.out.println("=====================");
		}
		catch(Exception e) {
		//	e.printStackTrace();
			System.out.println("Problem is  ::"+e.getMessage());
		}
		System.out.println("BootIocProj07RealtimeDiMinProjectLayeredAppApplication.main() (end)");
	}

}
