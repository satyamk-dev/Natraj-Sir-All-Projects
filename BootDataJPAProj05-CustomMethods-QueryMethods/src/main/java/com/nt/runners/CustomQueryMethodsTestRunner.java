package com.nt.runners;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IHospitalRepository;

@Component
public class CustomQueryMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private  IHospitalRepository hsRepo;

	@Override
	public void run(String... args) throws Exception {
		
		/*try {
			List<Hospital>  list=hsRepo.showHospitalsByLocations("hyd", "mumbai", "delhi");
			list.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			hsRepo.fetchHospitalsByBedSize(400,5000).forEach(System.out::println);
				System.out.println("---------------------");
				hsRepo.fetchHospitalsDataByBedSize(300, 700).forEach(row->{
					System.out.println(Arrays.toString(row));
				});
				System.out.println("---------------------");
			hsRepo.fetchHospitalsNameByBedSize("hyd", "mumbai","vizag").forEach(System.out::println);
			*/    
			
		/*	try {
			
			Optional<Hospital> opt=hsRepo.getHospitalByName("KIMS");
			if(opt.isPresent()) {
				System.out.println("The Hospital Details are ::"+opt.get());
			}
			else {
				System.out.println("Hospital not found");
			}
				
			System.out.println("-----------------------");
			Object  data=hsRepo.getHospitalDataByName("KIMS");
			Object[]  row=(Object[])  data;
		     for(Object  o:row) {
		    	 System.out.print(o+"   ");
		     }
		     System.out.println();
		 	System.out.println("-----------------------");
			   String location=hsRepo.getHospitalLocationByName("KIMS");
			   System.out.println("hospital location is ::"+location);
		     
		}
			
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
		   long count=hsRepo.getUnquiteLocationsCount();
		   System.out.println("Hospitals  location count is ::"+count);
		   System.out.println("-------------------------");
		   Object row[]=(Object[]) hsRepo.getHospitalAggregateData();
		   System.out.println("Hospital  aggregate data  ::"+Arrays.toString(row));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			/*	long count=hsRepo.updateHospitalSizeByLocation("hyd", 15.0);
				System.out.println("no.of hospitals that are updated::"+count);
			*/
			/*long count=hsRepo.deleteHospitalsBySizeRange(300, 500);
			System.out.println("no.of  hospital that are deleted  :"+count);
			*/	
		    LocalDateTime  ldt=hsRepo.showSysDateAndTime();
		    System.out.println("System  date and time ::"+ldt);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
