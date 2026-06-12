package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Hospital;
import com.nt.service.IHospitalMgmtService;

@Component
public class JPARepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private  IHospitalMgmtService hsService;

	@Override
	public void run(String... args) throws Exception {
		
		/*try {
			String  msg=hsService.removeHospitalsByIdsInBatch(List.of(1003,1004,1006,1008,1009,1100,1120));
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
		    Hospital hs=new Hospital();
		    hs.setLocation("hyd"); hs.setSize(500);
		    List<Hospital>  list=hsService.showHospitalsByExampleData(hs, true, "name");
		   list.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/	
	
		/*try {
			String msg= hsService.showHospitalById(1010);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
			try {
				Hospital proxy=hsService.getHospitalById(10145);
				//System.out.println("proxy obj class name ::"+proxy.getClass()+"...."+proxy.getClass().getSuperclass());
		//		System.out.println(proxy.getName());
			//	System.out.println(proxy.getSize());
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}

}
