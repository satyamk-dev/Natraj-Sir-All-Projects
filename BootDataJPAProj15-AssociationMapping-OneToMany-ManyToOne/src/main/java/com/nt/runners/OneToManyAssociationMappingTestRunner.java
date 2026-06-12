package com.nt.runners;

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
		/*   try {
			   //parent object
			   Person per=new Person("rajesh","hyd");
			   //child objects
			   PhoneNumber ph1=new PhoneNumber(999999991L, "personal", "airtel");
			   PhoneNumber ph2=new PhoneNumber(8888888882L, "office", "jio");
			   // link parent with childs
			   ph1.setPer(per); ph2.setPer(per);
			   //  link childs objects to parent object
			   per.setPhones(Set.of(ph1, ph2));
			   //invoke the method
			   String msg=service.savePersonAndHisPhoneNumbers(per);
			   System.out.println(msg);
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }*/

		/*  try {
			   //parent object
			   Person per=new Person("mahesh","hyd");
			   //child objects
			   PhoneNumber ph1=new PhoneNumber(911999991L, "personal", "airtel");
			   PhoneNumber ph2=new PhoneNumber(8118888882L, "office", "jio");
			   // link parent with childs
			   ph1.setPer(per); ph2.setPer(per);
			   //  link childs objects to parent object
			   per.setPhones(Set.of(ph1, ph2));
			   //invoke the method
			   String msg=service.savePhoneNumbersAndAPerson(ph1, ph2);
			   System.out.println(msg);
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }*/

		/*try {
			 List<Person>  list=service.getPersonsAndTheirPhoneNumbers();
			 list.forEach(per->{
				 System.out.println("Parent ::"+per);
				 Set<PhoneNumber>  phones=per.getPhones();
				 phones.forEach(ph->{
					 System.out.println("Child::"+ph);
				 });
				 System.out.println("---------------------");
			 });
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*	try {
				List<PhoneNumber>  list=service.getPhoneNumbersAndTheirPersons();
				list.forEach(ph->{
					System.out.println("Child ::"+ph);
				     Person per=ph.getPer();
				     System.out.println("parent ::"+per);
				     System.out.println("---------------------");
				});
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*	try {
				String msg=service.removePersonAndHisPhoneNumbers(52);
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		
		/*try {
			String msg=service.removePhoneNumbersAndAssociatedPerson(100, 101);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*	try {
			String msg=service.removeOnlyPhoneNumbersOfAPerson(102);
			System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*	try {
				PhoneNumber ph1=new PhoneNumber(999999911L,"office","jio");
				String msg=service.addNewPhoneNumberToPerson(102, ph1);
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		try {
			String  msg=service.movePhoneNumberFromOnePersonToAnotherPerson(102, 101, 999999911L);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//main

}//class
