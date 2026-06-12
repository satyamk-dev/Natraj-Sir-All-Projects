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
	
	
	/*CREATE OR REPLACE PROCEDURE P_GET_HOSPITALS_BY_SIZE 
	(
	  STARTSIZE IN NUMBER 
	, ENDSIZE IN NUMBER 
	, DETAILS  OUT SYS_REFCURSOR 
	) AS 
	BEGIN
	  
	  OPEN DETAILS FOR
	     SELECT * FROM JPA_HOSPITAL WHERE H_SIZE>=STARTSIZE and H_SIZE<=ENDSIZE;
	  
	  
	END P_GET_HOSPITALS_BY_SIZE;
	*/
	@Override
	
	public List<Hospital> showHospitalsBySize(int startSize, int endSize) {
		//create StroredProcedureQuery object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_HOSPITALS_BY_SIZE",Hospital.class);
		//register  the parmas
		query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Object.class, ParameterMode.REF_CURSOR);
		//set  values to query params
		query.setParameter(1, startSize);
		query.setParameter(2, endSize);
		//execute the Query(call PL/SQL procedure)
		List<Hospital>  list=query.getResultList();
		return list;
	}

}
