package com.nt.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Hospital;
import com.nt.exception.HospitalNotFoundException;
import com.nt.repository.IHospitalRepository;

@Service
public class HospitalMgmtServiceImpl implements IHospitalMgmtService {
	@Autowired
	private   IHospitalRepository   hsRepo;

	@Override
	public String saveHospital(Hospital hospital) {
		System.out.println(hsRepo.getClass()+"....."+Arrays.toString(hsRepo.getClass().getInterfaces()));
		System.out.println(Arrays.toString(hsRepo.getClass().getMethods()));
		//save the object
		Hospital  savedHS=hsRepo.save(hospital);
		//get the id value
		int idVal=savedHS.getHid();
		return  "Hospitable obj is saved with id value :"+idVal;
	}
	
	@Override
	public Long showHospitalsCount() {
          //use  repo
		long count=hsRepo.count();
		return count;
	}
	
	@Override
	public String checkHospitalById(int id) {
		//use repo
		boolean flag=hsRepo.existsById(id);
		return flag==true?"Hospital Found":"Hospitable not found";
	}
	
	@Override
	public String saveMultipleHospitals(List<Hospital> list) {
		// use repo
		Iterable<Hospital>  savedList=hsRepo.saveAll(list);
		//get the generated id vlaues
		/*List<Integer> idList=new ArrayList();
		savedList.forEach(hs->{
			idList.add(hs.getHid());
		});*/
		//use repo
		List<Integer>  idsList=StreamSupport.stream(savedList.spliterator(), false).map(Hospital::getHid).collect(Collectors.toList());
		
		return idsList.size()+" no.of records are inserted with id vlaues::"+idsList;
	}
	
	@Override
	public Iterable<Hospital> showAllHospitals() {
	   //use repo
		Iterable<Hospital>  it=hsRepo.findAll();
		return it;
	}
	
	@Override
	public Iterable<Hospital> showHospitalsByIds(List<Integer> ids) {
		//use repo
		Iterable<Hospital>  it=hsRepo.findAllById(ids);
		return it;
	}

	@Override
	public Optional<Hospital> showHospitalById(int id) {
		//use repo
	   Optional<Hospital>  opt=hsRepo.findById(id);
	   return  opt;
	}
	
	@Override
	public String fetchHospitalById(int id) {
		Optional<Hospital>  opt=hsRepo.findById(id);
		if(opt.isPresent())
			return  "Hospital  details are :"+opt.get();
		else
			return  "Hospital  not found";
	}
	
	/*@Override
	public Hospital getHospitalById(int id) {
		Optional<Hospital>  opt=hsRepo.findById(id);
		if(opt.isPresent())
			return   opt.get();
		else
			throw new HospitalNotFoundException("Invalid Id");
			//throw  new IllegalArgumentException("Invalid Id");
	}*/
	
	
	public Hospital getHospitalById(int id) {
		Hospital hs=hsRepo.findById(id).orElseThrow(()-> new HospitalNotFoundException("Invalid Id"));
		return hs;
	}
	
	@Override
	public Hospital displayHospitalById(int id) {
		 Hospital phc=new  Hospital(0001,"Village-PHC", "village", 5);
		 Hospital  hs=hsRepo.findById(id).orElse(phc);
		return hs;
	}
	
	

	@Override
	public String updateHospitalSize(int hid,int sizePercent) {
	  //Load object
		Hospital hs=hsRepo.findById(hid).orElseThrow(()-> new HospitalNotFoundException("Invalid Id"));
		//update the object
		hs.setSize(hs.getSize()+ Math.round(hs.getSize()*sizePercent/100));
		//update the object
		hsRepo.save(hs);
		return hid+"  Hospital size is updated ";
	}
	
	@Override
	public String registerOrUpdateHospitalbe(Hospital hs) {
		 //Load object
		Optional<Hospital> opt=hsRepo.findById(hs.getHid());
		
	      if(opt.isPresent()) {
	    	  hsRepo.save(hs);
	    	  return "Hospitable object is updated";
	      }
	      else {
	    	Hospital savedHs=hsRepo.save(hs);
	    	  return "Hospitable object is  saved with id value ::"+savedHs.getHid();
	      }
	}

	@Override
	public String removeHospitalById(int id) {
	      // check  the object availability
		boolean flag=hsRepo.existsById(id);
		if(flag) {
		     hsRepo.deleteById(id);
		     return id+" Hospital is deleted";
		}
		return id+" Hospital is not found  for deletion";
	}
	
	@Override
	public String removeHospitalsByIds(List<Integer> ids) {
		//load the   Hospitals 
		Iterable<Hospital>  list=hsRepo.findAllById(ids);
		//get  count of  loaded hopsitals
		long count=StreamSupport.stream(list.spliterator(), false).count();
		//delete the objects
		if(count==0) {
			return ids+" hospitals are not found";
		}
		else {
			hsRepo.deleteAllById(ids);
			return count +"no.of hospitals are found and deleted ";
		}
	}
	
	@Override
	public String removeAllHospitals() {
		//use repo
		long count=hsRepo.count();
		if(count!=0) {
			hsRepo.deleteAll();
			return count+" no.of  records from the table are deleted and the table has become empty ";
		}
		return count+" table is  empty";
	}

}
