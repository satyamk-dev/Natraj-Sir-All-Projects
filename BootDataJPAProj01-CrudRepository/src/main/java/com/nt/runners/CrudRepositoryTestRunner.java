package com.nt.runners;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Hospital;
import com.nt.service.IHospitalMgmtService;

@Component
public class CrudRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private  IHospitalMgmtService hsService;

	@Override
	public void run(String... args) throws Exception {
		/*		try {
					// create Entity class object
					  Hospital  hs=new Hospital();
					  hs.setName("NIMS"); hs.setLocation("hyd"); hs.setSize(1000);
					  //use service
					   String msg=hsService.saveHospital(hs);
					  System.out.println(msg);
				}//try
				catch(Exception e) {
					e.printStackTrace();
				}*/
				
		/*	try {
				long count=hsService.showHospitalsCount();
				System.out.println("hospitals count::"+count);
			}
			catch(Exception  e) {
				e.printStackTrace();
			}*/
		
		/*try {
		   String msg=hsService.checkHospitalById(111);
		   System.out.println(msg);
		}
		catch(Exception e) {
		  e.printStackTrace();
		}
		*/
		
		try {
			Hospital hs1=new Hospital("LIMS","hyd",5100);
			Hospital hs2=new Hospital("LIMS1","hyd",5200);
			Hospital hs3=new Hospital("LIMS2","hyd",5300);
			List<Hospital>  list=List.of(hs1,hs2,hs3);
			//use service
			String  msg=hsService.saveMultipleHospitals(list);
			System.out.println(msg);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		/*	try {
				Iterable<Hospital>  it=hsService.showAllHospitals();
				it.forEach(System.out::println);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*try {
			Iterable<Hospital>  it=hsService.showHospitalsByIds(Arrays.asList(102,52,1,2,null,100));
			it.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*	try {
				Optional<Hospital>  opt=hsService.showHospitalById(1152);
				if(opt.isEmpty())
					System.out.println("Hospital  not found");
				else {
					Hospital  hs=opt.get();
					System.out.println("Hospital found::"+hs);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*	try {
				String msg=hsService.fetchHospitalById(152);
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*	try {
				Hospital  hs=hsService.getHospitalById(3);
				System.out.println("Hospital Details are ::"+hs);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*	try {
		
				Hospital hs=hsService.displayHospitalById(1521);
				System.out.println("Hospitable Details  are ::"+hs);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*	try {
				 String  msg=hsService.updateHospitalSize(3, 20);
				 System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*try {
			Hospital hs=new Hospital(16, "NayaJIMS1", "new hyd2",500);
			String msg=hsService.registerOrUpdateHospitalbe(hs);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*	try {
				String msg=hsService.removeHospitalById(3);
				System.out.println(msg);
				}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*	try {
				String msg=hsService.removeHospitalsByIds(List.of(1,2,4,5,16));
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*		try {
					String msg=hsService.removeAllHospitals();
					System.out.println(msg);
				}
				catch(Exception e) {
					e.printStackTrace();
				}*/
		

	}

}
