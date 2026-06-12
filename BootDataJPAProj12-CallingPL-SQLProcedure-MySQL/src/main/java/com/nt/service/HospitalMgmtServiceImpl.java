package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Hospital;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class HospitalMgmtServiceImpl implements IHospitalMgmtService {
	@Autowired
	private EntityManager  manager;
	
	
	/*USE `ntspbms916db`;
	DROP procedure IF EXISTS `get_hospitals_by_size`;
	
	USE `ntspbms916db`;
	DROP procedure IF EXISTS `ntspbms916db`.`get_hospitals_by_size`;
	;
	
	DELIMITER $$
	USE `ntspbms916db`$$
	CREATE DEFINER=`root`@`localhost` PROCEDURE `get_hospitals_by_size`(in min integer , in max integer)
	BEGIN
	  select  *  from  jpa_hospital where h_size>=min and h_size<=max;
	END$$
	
	DELIMITER ;
	;*/
	
	@Override
		public List<Hospital> showHospitalsBySize(int startSize, int endSize) {
		//create StroredProcedureQuery object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("get_hospitals_by_size",Hospital.class);
		//register  the parmas
		query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
		//set  values to query params
		query.setParameter(1, startSize);
		query.setParameter(2, endSize);
		//execute the Query(call PL/SQL procedure)
		List<Hospital>  list=query.getResultList();
		return list;
	}

}
