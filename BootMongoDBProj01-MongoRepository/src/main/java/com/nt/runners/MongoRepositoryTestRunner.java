package com.nt.runners;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Product;
import com.nt.service.IProductMgmtService;

@Component
public class MongoRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private   IProductMgmtService  prodService;

	@Override
	public void run(String... args) throws Exception {
		try {
			Product prod=new Product();
			prod.setId(UUID.randomUUID().toString());
			prod.setPid(1002); prod.setName("teapoy");
			prod.setQty(50.0);
			prod.setCompany("IKEA"); prod.setPrice(3000.0);
			//save the object
			String msg=prodService.saveProduct(prod);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		/*	try {
				Product prod1=new Product();
				prod1.setPid(434); prod1.setName("chair");
				Product prod2=new Product();
				prod2.setPid(431); prod2.setName("sofa"); prod2.setPrice(5678.0);
				//invoke the methods
				String msg=prodService.saveProducts(List.of(prod1,prod2));
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*try {
			List<Product>  list=prodService.showAllProducts();
			list.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*	try {
				Product prod=prodService.showProductId("69e307d6716f586a62693308");
				System.out.println(prod);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*try {
			String msg=prodService.updateProductPrice("69e307d6716f586a62693308", 10.0);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			String msg= prodService.removeProductsByNameAndCatetory("table", "IKEA");
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

	}


}
