package com.nt.service;

import java.util.List;

import com.nt.entity.Hospital;

public interface IHospitalMgmtService {
   public  List<Hospital>  showHospitalsBySize(int startSize,int endSize);
}
