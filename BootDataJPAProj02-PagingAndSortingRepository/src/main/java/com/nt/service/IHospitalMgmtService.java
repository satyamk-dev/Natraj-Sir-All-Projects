package com.nt.service;


import org.springframework.data.domain.Page;

import com.nt.entity.Hospital;

public interface IHospitalMgmtService {
	
	public  Iterable<Hospital>  showHospitalsSorted(boolean ascOrder,String ...props);
	public  Page<Hospital>  showHospitalsByPagination(int pageNo, int pageSize);
	public  Page<Hospital>  showHospitalsByPaginationAndSorting(int pageNo, int pageSize,boolean ascOrder,String ...props);
	public  void   showHospitalsByPagination(int pageSize);
	
 }
