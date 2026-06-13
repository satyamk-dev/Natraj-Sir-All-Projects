package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.vo.DoctorVO;

public interface IDoctorMgmtService {
   public  String  registerDoctor(DoctorVO  vo);
   public   List<DoctorVO>  showAllDoctors();
   public    DoctorVO   showDoctorById(int id);
   public   String   updateDoctor(DoctorVO vo);
   public   String  removeDoctorById(int id);
   
   public  Page<DoctorVO>  showDoctorsByPagination(Pageable pageable);
   
}
