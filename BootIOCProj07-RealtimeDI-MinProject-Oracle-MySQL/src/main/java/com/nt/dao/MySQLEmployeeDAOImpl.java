package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("mysqlEmpDAO")
public class MySQLEmployeeDAOImpl implements IEmployeeDAO {
	  //SQL Queries declaration
	private  static final  String   GET_EMPS_BY_DESGS="SELECT ENO,ENAME,DESG,SALARY FROM EMP_TAB WHERE DESG IN(?,?,?)  ORDER BY DESG";
	private  static  final String    INSERT_EMPS_QUERY="INSERT INTO EMP_TAB(ENAME,DESG,SALARY) VALUES(?,?,?)";
	// DataSource Injection
	@Autowired
	private  DataSource ds;

	@Override
	public List<Employee> showEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("DataSource obj class name ::"+ds.getClass());
		 List<Employee>   list=null;
		try(  //get Pooled jdbc con
				Connection con=ds.getConnection();
				//create PreparedStatement object
				PreparedStatement ps=con.prepareStatement(GET_EMPS_BY_DESGS);
				){
			    //set  values to  query params
			     ps.setString(1, desg1);
			     ps.setString(2, desg2);
			     ps.setString(3, desg3);
			     //execute the SQL Query
			     try(ResultSet rs=ps.executeQuery()){
			    	 //convert  ResultSet object records to  List<Employee>
			    	   list=new ArrayList();
			    	 while(rs.next()) {
			    		 //copy each record to Employee class obj
			    		 Employee emp=new Employee();
			    		 emp.setEno(rs.getInt(1));
			    		 emp.setEname(rs.getString(2));
			    		 emp.setDesg(rs.getString(3));
			    		 emp.setSalary(rs.getFloat(4));
			    		 //add each Employee class obj to  List collection
			    		 list.add(emp);
			    	 }//while
			     }//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
			throw se;  // Exception rethowing
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e; // Exception rethrowing
		}
		
		return list;
	}

	@Override
	public int insert(Employee emp) throws Exception {
		int count=0;
		//get  pooled jdbc con object
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(INSERT_EMPS_QUERY);
				){
			   //set  values to Query params
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getDesg());
			ps.setDouble(3, emp.getSalary());
			//execute the Query
			count=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
