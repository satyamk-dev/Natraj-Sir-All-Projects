package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Hospital;

public interface IHospitalMgmtService {
    public String saveHospital(Hospital hospital);
    public   Long  showHospitalsCount();
    public   String   checkHospitalById(int id);
    public  String   saveMultipleHospitals(List<Hospital> list);
    public  Iterable<Hospital>  showAllHospitals();
    public  Iterable<Hospital>  showHospitalsByIds(List<Integer> ids);
    public  Optional<Hospital> showHospitalById(int id);
    public  String    fetchHospitalById(int id);
    public   Hospital  getHospitalById(int id);
    public   Hospital   displayHospitalById(int id);
    public   String   updateHospitalSize(int hid,int sizePercent);
    public  String    registerOrUpdateHospitalbe(Hospital hs);
    public  String    removeHospitalById(int  id);
    public  String   removeHospitalsByIds(List<Integer> ids);
    public  String   removeAllHospitals();
}
