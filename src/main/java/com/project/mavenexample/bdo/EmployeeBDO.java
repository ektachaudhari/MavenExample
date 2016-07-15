package com.project.mavenexample.bdo;

import java.util.List;

import com.google.gson.Gson;
import com.project.mavenexample.datastore.EmployeeDAO;
import com.project.mavenexample.pojo.Employee;

public class EmployeeBDO {
	private static int empId = 0;
	private Gson gson = new Gson();
	Employee employee;

	/* create Employee detail */
	public String createEmployeeDetail(String name,String surname) throws Exception {		
		/*Employee employee=gson.fromJson(jsonString, Employee.class);*/
		System.out.println(name+surname);
		employee = new Employee();
		employee.setEmpid(++empId);
		employee.setName(name);
		employee.setSurname(surname);
		EmployeeDAO.getInstance().add(employee.getEmpid(),employee);		
		return gson.toJson(employee, Employee.class);
	}
	
	/*update Employee detail*/
	public String updateEmployee(String jsonString) throws Exception{
		employee = new Employee();
		employee=gson.fromJson(jsonString,Employee.class);		
		EmployeeDAO.getInstance().add(employee.getEmpid(),employee);
		return gson.toJson(employee,Employee.class);		
	}
	
	/*get all employee list*/
	public String getEmployeeList() throws Exception{		
		return  new Gson().toJson(EmployeeDAO.getInstance().getList());
		
	}
	
	/*delete Employee detail*/
	public void deleteEmployee(int id) throws Exception{		
		EmployeeDAO.getInstance().remove(id);
	}	
	

	
	
	
	

}
