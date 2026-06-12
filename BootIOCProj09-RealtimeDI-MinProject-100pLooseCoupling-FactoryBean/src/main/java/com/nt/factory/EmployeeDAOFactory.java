package com.nt.factory;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nt.dao.IEmployeeDAO;
import com.nt.dao.MySQLEmployeeDAOImpl;
import com.nt.dao.OracleEmployeeDAOImpl;


@Component("daoFactory")
public class EmployeeDAOFactory implements FactoryBean<IEmployeeDAO> {
	@Value("${dao.id}")
	private   String  daoId;
	@Autowired
	private  OracleEmployeeDAOImpl  oraDAO;
	
	@Autowired
	private   MySQLEmployeeDAOImpl  mysqlDAO;

	@Override
	public IEmployeeDAO getObject() throws Exception {
		switch(daoId) {
		    case "oraEmpDAO":
		    	  return oraDAO;
		    case "mysqlEmpDAO":
		    	  return mysqlDAO;
		    default:
		    	   throw new IllegalArgumentException("Invalid id");
		}
	
	}

	@Override
	public @Nullable Class<?> getObjectType() {
		return IEmployeeDAO.class;
	}

}
