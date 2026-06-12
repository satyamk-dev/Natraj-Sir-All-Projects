package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Product;
import com.nt.service.IProductMgmtService;

@Component
public class MongoTemplateTestRunner implements CommandLineRunner {
	@Autowired
	private   IProductMgmtService  prodService;

	@Override
	public void run(String... args) throws Exception {
		
		/*try {
			Product  prod=new Product(null, 4561, "table", 4567.0, 10.0, "furniture","Ikea");
		     String msg=prodService.saveProduct(prod);
		     System.out.println(msg);
		     System.out.println("==============");
		     Student  st=new Student(null,3455,"raja","hyd",56656.0);
		     String  msg1=prodService.saveStudent(st);
		     System.out.println(msg1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			Product prod1=new Product(null, 1001, "sofa",5455.0, 10.0, "furniture", "ikea");
			Product prod2=new Product(null, 1002, "chair",5155.0, 11.0, "furniture", "ikea");
			String msgs=prodService.saveProducts(List.of(prod1,prod2));
			System.out.println(msgs);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		/*try {
			List<Product> list=prodService.showProductsByPriceRange(300.0, 5000.0);
			list.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			List<Product>  list=prodService.showProductsByCategory("furniture");
			list.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			String msg=prodService.updatePriceByCategory("furniture", 10.0);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*	try {
				String msg=prodService.removeProductsByPriceRange(100.0, 2000.0);
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		try {
			String msg=prodService.countProductsByCategory("furniture");
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}


}
