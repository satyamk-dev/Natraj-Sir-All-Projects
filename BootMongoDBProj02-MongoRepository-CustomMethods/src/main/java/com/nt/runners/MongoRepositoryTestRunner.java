package com.nt.runners;

import java.util.Arrays;
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
		/*		try {
					List<Product>  list=prodService.showProductByName("table");
					list.forEach(System.out::println);
				}
				catch(Exception e) {
					e.printStackTrace();
				}*/
		
		/*try {
			List<Product>  list=prodService.show
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			List<Product>  list=prodService.showProductsByPriceRange(400.0, 7000.0);
			list.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			List<Product>  list=prodService.fetchProductsByName("table");
			list.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			List<Object[]>  list=prodService.fetchProductsDataByName("table");
			list.forEach(row->{
				System.out.println(Arrays.toString(row));
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			List<Product>  list=prodService.fetchProductsByPriceRange(500.0, 4000.0);
			list.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			List<Product>  list=prodService.fetchProductsByNamesIn(List.of("table","chair","sofa"));
			list.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			List<Product>  list=prodService.fetchProductsByNameChars("t");
			list.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


}
