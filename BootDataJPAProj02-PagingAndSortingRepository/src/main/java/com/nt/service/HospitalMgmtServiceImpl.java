package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.Hospital;
import com.nt.repository.IHospitalRepository;

@Service
public class HospitalMgmtServiceImpl implements IHospitalMgmtService {
	@Autowired
	private   IHospitalRepository   hsRepo;

	@Override
	public Iterable<Hospital> showHospitalsSorted(boolean ascOrder ,String ...props) {
		//prepare Sort object
		Sort sort=Sort.by(ascOrder?Sort.Direction.ASC: Sort.Direction.DESC, props);
		//invoke the method
		Iterable<Hospital>  it=hsRepo.findAll(sort);
		return it;
	}
	
	@Override
	public Page<Hospital> showHospitalsByPagination(int pageNo, int pageSize) {
		// prepare  Pageable obj having  pageNo and pageSize
		Pageable  pageable=PageRequest.of(pageNo, pageSize);
		// get  the requested page records
		Page<Hospital>  page=hsRepo.findAll(pageable);
		//return  page
		return page;
	}
	
	@Override
	public Page<Hospital> showHospitalsByPaginationAndSorting(int pageNo, 
			                                                                           int pageSize, boolean ascOrder,String... props) {
		//prepare Sort object
		Sort sort=Sort.by(ascOrder?Sort.Direction.ASC: Sort.Direction.DESC, props);
		//create Pageable object
		Pageable  pageable=PageRequest.of(pageNo, pageSize,sort);
	    //invok the method
		Page<Hospital>  page=hsRepo.findAll(pageable);
		return page;
	}
	
	
	@Override
	public void showHospitalsByPagination(int pageSize) {
		//get total no.of records
		long count=hsRepo.count();
		// get pages count
		long pagesCount=count/pageSize;
		if(count%pageSize!=0)
			pagesCount++;
		
		//create Pageable object and perform pagination
		for(int i=0;i<pagesCount;++i) {
			Pageable pageable=PageRequest.of(i, pageSize);
			Page<Hospital> page=hsRepo.findAll(pageable);
			System.out.println("records of "+(page.getNumber()+1)+"/ "+page.getTotalPages());
			page.forEach(System.out::println);
			System.out.println("=======================");
		}
		
		
	}//method
	
}//class
