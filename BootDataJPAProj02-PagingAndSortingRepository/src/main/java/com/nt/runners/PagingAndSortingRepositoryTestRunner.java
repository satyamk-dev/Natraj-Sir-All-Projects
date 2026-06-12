package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Hospital;
import com.nt.service.IHospitalMgmtService;

@Component
public class PagingAndSortingRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private  IHospitalMgmtService hsService;

	@Override
	public void run(String... args) throws Exception {
		
		/*try {
			 Iterable<Hospital> it=hsService.showHospitalsSorted(false, "name","size");
			 it.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*	try {
				Page<Hospital>  page=hsService.showHospitalsByPagination(8, 4);
				Iterable<Hospital>  it=page.getContent();
				System.out.println("records of  "+ (page.getNumber()+1)+" /"+page.getTotalPages());
				it.forEach(System.out::println);
				System.out.println("current page number ::"+ (page.getNumber()+1));
				System.out.println("total  pages ::"+page.getTotalPages());
				System.out.println("  no.of records in the current page ::"+page.getNumberOfElements());
				System.out.println(" is it the first page ::"+page.isFirst());
				System.out.println(" is it the last page ::"+page.isLast());
				System.out.println(" is   this page haiving next page? ::"+page.hasNext());
				System.out.println(" is   this page haiving previous page? ::"+page.hasPrevious());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		*/			
		
		/*	try {
				Page<Hospital> page=hsService.showHospitalsByPaginationAndSorting(2, 3,true,"name","size");
				page.getContent().forEach(System.out::println);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		try {
			hsService.showHospitalsByPagination(5);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
