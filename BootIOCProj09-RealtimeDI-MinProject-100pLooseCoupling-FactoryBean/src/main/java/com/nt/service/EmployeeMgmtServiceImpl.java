package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
@Qualifier("daoFactory")
	private IEmployeeDAO  empDAO;

	public EmployeeMgmtServiceImpl() {
		System.out.println("EmployeeMgmtServiceImpl: 0-param constructor");
	}
	
	@Override
	public List<Employee> showEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
		//convert the desgs to upper case letters  (b.logic)
		desg1=desg1.toUpperCase();
		desg2=desg2.toUpperCase();
		desg3=desg3.toUpperCase();
		//use  DAO
		List<Employee> list=empDAO.showEmployeesByDesgs(desg1, desg2, desg3);
		//calculate grossSalary and netSalary  (b.logic)
		list.forEach(emp->{
			emp.setGrossSalary(emp.getSalary()+ (emp.getSalary()* 0.4f));
			emp.setNetSalary(emp.getGrossSalary()- (emp.getSalary()*0.2f));
		});
		return list;
	}

	@Override
	public String registerEmployee(Employee emp) throws Exception {
	    //use  DAO
		int  count=empDAO.insert(emp);
		return count==0?"Employee not registered":"Employee is registered Successfully";
	}

}
