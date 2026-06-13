package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.DoctorEntity;
import com.nt.error.DoctorNotFoundException;
import com.nt.repository.IDoctorRepository;
import com.nt.vo.DoctorVO;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {
	@Autowired
	private   IDoctorRepository  doctorRepo;

	@Override
	public String registerDoctor(DoctorVO vo) {
		//convert  DoctorVO  to DoctoEntity
		DoctorEntity entity=new DoctorEntity();
		BeanUtils.copyProperties(vo, entity);
		entity.setCreatedBy(System.getProperty("user.name"));
		//register Doctor
		int idVal=doctorRepo.save(entity).getDid();
		
		return "Doctor object is saved with the id Value ::"+idVal;
	}

	@Override
	public List<DoctorVO> showAllDoctors() {
		//use  service
		List<DoctorEntity>  listEntities=doctorRepo.findAll();
		//convert ListEntities to listVO
		List<DoctorVO>  listVO=new ArrayList<DoctorVO>();
		listEntities.forEach(entity->{
			DoctorVO vo=new DoctorVO();
			BeanUtils.copyProperties(entity, vo);
			//calculate  final fee
			if(vo.getFee()<500.0)
				vo.setDiscount(10.0);
			else
				vo.setDiscount(20.0);
			vo.setNetFee(vo.getFee()-(vo.getFee()* vo.getDiscount()/100.0f));
			listVO.add(vo);
		});
		return listVO;
	}
	
	@Override
	public DoctorVO showDoctorById(int id) {
		//Load the object
		DoctorEntity  entity=doctorRepo.findById(id).orElseThrow(()->new  DoctorNotFoundException("Invalid Id"));
		//convert Entity object to vo object
		DoctorVO  vo=new DoctorVO();
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}
	
	@Override
	public String updateDoctor(DoctorVO vo) {
		//Load the object
		DoctorEntity  entity=doctorRepo.findById(vo.getDid()).orElseThrow(()->new  DoctorNotFoundException("Invalid Id"));
		//convert  vo object to entity object
		BeanUtils.copyProperties(vo, entity);
		//update the object
		doctorRepo.save(entity);
		
		return  vo.getDid()+" Doctor details are updated";
	}
	
	@Override
	public String removeDoctorById(int id) {
		//Load the object
		DoctorEntity  entity=doctorRepo.findById(id).orElseThrow(()->new  DoctorNotFoundException("Invalid Id"));
		// delete the object
		doctorRepo.deleteById(id);
		return id+" Doctor Details  are deleted";
	}
	


}
