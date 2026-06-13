package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.DoctorEntity;
import com.nt.exceptions.DoctorNotFoundException;
import com.nt.repository.IDoctorRepository;
import com.nt.vo.DoctorVO;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {
	@Autowired
	private  IDoctorRepository  doctorRepo;

	@Override
	public String registerDoctor(DoctorVO vo) {
		//Convert  vo to entity
		DoctorEntity entity=new DoctorEntity();
		BeanUtils.copyProperties(vo, entity);
		entity.setCreatedBy(System.getProperty("user.name"));
		//use the repo
		int idVal=doctorRepo.save(entity).getDid();
		return  "Doctor object is saved with id Value :"+idVal;
	}
	
	@Override
	public String registerDoctors(List<DoctorVO> listVO) {
		//convert  listVO to listEntity
		List<DoctorEntity>  listEntity=new ArrayList();
		listVO.forEach(vo->{
			DoctorEntity entity=new DoctorEntity();
			BeanUtils.copyProperties(vo, entity);
			entity.setCreatedBy(System.getProperty("user.name"));
			listEntity.add(entity);
		});
		 //save  ListEntities
		List<DoctorEntity> savedEntities=doctorRepo.saveAll(listEntity);
		//get id values
        List<Integer> ids=savedEntities.stream().map(DoctorEntity::getDid).toList();
        return  ids.size()+" no.of Doctors are saved with with id values ::"+ids;
	}

	
	@Override
	public DoctorVO showDoctorById(int id) {
	// use repo
		DoctorEntity  entity=doctorRepo.findById(id).orElseThrow(()->new DoctorNotFoundException("Invalid Doctor ID"));
    // copy  entity to vo object
		DoctorVO vo=new DoctorVO();
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}
	
	@Override
	public List<DoctorVO> showAllDoctors() {
		//use repo
		List<DoctorEntity> listEntity=doctorRepo.findAll();
		//convert  listEntities  to listVO
		List<DoctorVO>  listVO=new ArrayList();
		listEntity.forEach(entity->{
			DoctorVO vo=new DoctorVO();
			BeanUtils.copyProperties(entity, vo);
			listVO.add(vo);
		});
		 //sort the  listVO
		listVO.sort((v1,v2)->v1.getDname().compareTo(v2.getDname()));
		//return list VO
		return listVO;
	}
	
	@Override
	public String hikeDoctorFeeById(int did, float hikePercent) {
		// use repo
		DoctorEntity  entity=doctorRepo.findById(did).orElseThrow(()->new DoctorNotFoundException("Invalid Doctor ID"));
		entity.setFee(entity.getFee()+ (entity.getFee()* hikePercent/100.0));
		entity.setUpdatedBy(System.getProperty("user.name"));
		// update the object
		  doctorRepo.save(entity);
		return did+" Doctor Fee is updated by "+entity.getFee();
	}
	
	@Override
	public String updateDoctorDetails(DoctorVO vo) {
		// use repo
		DoctorEntity  entity=doctorRepo.findById(vo.getDid()).orElseThrow(()->new DoctorNotFoundException("Invalid Doctor ID"));
	   // convert vo to entity
		BeanUtils.copyProperties(vo, entity);
		entity.setUpdatedBy(System.getProperty("user.name"));
		//update the object
		doctorRepo.save(entity);
		return vo.getDid()+"Doctor Details are updated";
	}
	
	@Override
	public String removeDoctorById(int id) {
		// use repo
		DoctorEntity  entity=doctorRepo.findById(id).orElseThrow(()->new DoctorNotFoundException("Invalid Doctor ID"));
		//use repo
		doctorRepo.deleteById(id);
		
		return id+" Doctor is deleted";
	}

	@Override
	public String removeDoctorsByFeeRange(float startFee, float endFee) {
		//use  repo
		int count=doctorRepo.removeDoctorsByFeeRange(startFee, endFee);
		return count==0?"No Doctors Found for Deletion": count+" no.of Doctors are Deleted";
	}
	

}
