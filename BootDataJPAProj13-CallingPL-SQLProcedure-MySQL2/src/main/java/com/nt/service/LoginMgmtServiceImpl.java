package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("loginService")
public class LoginMgmtServiceImpl implements ILoginMgmtService {
	@Autowired
	private   EntityManager  manager;
	
	/*CREATE DEFINER=`root`@`localhost` PROCEDURE `authenticate`(in user varchar(30), in pass varchar(45), out result varchar(20))
			BEGIN
			declare cnt int(2);
			    select  count(*)  into cnt from  users_info where uname=user and pwd=pass;
			    if(cnt<>0) then
			       set result='Valid Credetials';
			     else
			       set result='Invalid Credentails';
			   end if;    
			END*/

	@Override
	public String login(String user, String pwd) {
		//create StoredProcedureQuery object
		StoredProcedureQuery  query=manager.createStoredProcedureQuery("AUTHENTICATE");
		//register the pararams
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		//set values to Query params
		query.setParameter(1, user);
		query.setParameter(2, pwd);
		//execute the Query
		String result=(String)query.getOutputParameterValue(3);
		return result;
	}

}
