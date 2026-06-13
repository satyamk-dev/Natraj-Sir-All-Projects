package com.nt.service;

import java.util.List;

import com.nt.vo.DoctorVO;

public interface IDoctorMgmtService {
   public  String   registerDoctor(DoctorVO vo);
   public   String   registerDoctors(List<DoctorVO> listVO);
   public   DoctorVO  showDoctorById(int id);
   public List<DoctorVO>  showAllDoctors();
   public  String   hikeDoctorFeeById(int did, float hikePercent);
   public  String   updateDoctorDetails(DoctorVO vo);
   public   String  removeDoctorById(int id);
   public   String   removeDoctorsByFeeRange(float  startFee ,float endFee);
}
