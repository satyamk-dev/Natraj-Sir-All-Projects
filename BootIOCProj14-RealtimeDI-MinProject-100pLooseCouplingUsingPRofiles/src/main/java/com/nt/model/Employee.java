//Employee.java (model class)
package com.nt.model;

import lombok.Data;

@Data
public class Employee   {
	private  Integer eno;
	private  String  ename;
	private   String  desg;
	private   Float  salary;
	private   Float grossSalary;
	private  Float netSalary;

}
