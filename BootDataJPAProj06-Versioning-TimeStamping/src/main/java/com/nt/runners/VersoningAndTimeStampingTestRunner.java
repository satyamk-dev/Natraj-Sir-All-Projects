package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.BankAccount;
import com.nt.service.IBankAccountMgmtService;

@Component
public class VersoningAndTimeStampingTestRunner implements CommandLineRunner {
	@Autowired
	private IBankAccountMgmtService bankService;

	@Override
	public void run(String... args) throws Exception {
		/*	try {
				BankAccount  account=new BankAccount("Suresh","ICICI","Ameerpet",19000.0);
				String msg=bankService.registerAccount(account);
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*try {
		  String msg=bankService.withdrawMoney(10000000, 4000.0);
		  System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("======================");

	}
*/
		
		try {
			String  msg=bankService.transferMoney(10000003,10000001 ,4000.0);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
  
	}
}