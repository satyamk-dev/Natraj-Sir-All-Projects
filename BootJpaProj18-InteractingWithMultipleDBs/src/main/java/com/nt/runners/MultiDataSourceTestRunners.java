package com.nt.runners;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.offers.Offers;
import com.nt.entity.prod.Product;
import com.nt.service.ICompanyMgmtService;

@Component
public class MultiDataSourceTestRunners implements CommandLineRunner {
	       @Autowired
           private   ICompanyMgmtService  compService;
	@Override
	public void run(String... args) throws Exception {
         try {
        	 // create Product object
        	 Product prod=new Product("table",456.0,20.0);
        	 Offers  offrs=new Offers("Summer Offer",LocalDate.of(2026, 6, 20));
        	 //invoke the method
        	 String msg=compService.saveProductAndOffers(prod, offrs);
        	 System.out.println(msg);
         }
         catch(Exception e) {
        	 e.printStackTrace();
         }


	}//main

}//class
