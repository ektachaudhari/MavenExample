package com.project.mavenexample.datastore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.mavenexample.pojo.Employee;

public class EmployeeDAO {

	private static EmployeeDAO employeeDAO;
	private Map<Integer, Employee> employeeList = new HashMap<Integer, Employee>();

	private EmployeeDAO() {

	}

	public static EmployeeDAO getInstance() {
		if (employeeDAO == null) {
			synchronized (EmployeeDAO.class) {
				if (employeeDAO == null) {
					employeeDAO = new EmployeeDAO();
				}
			}
		}
		return employeeDAO;
	}

	public void add(int key, Employee employee) {
		employeeList.put(key, employee);
		System.out.println(employee.getName()+" "+employee.getSurname());
	}

	public void remove(int key) {
		employeeList.remove(key);
	}

	public void init() {
		if (employeeList == null) {
			employeeList = new HashMap<>();
		}
	}
	
	public void destroy(){
		if(employeeList!=null){
			employeeList.clear();
			employeeList=null;
		}
	}
	
	public List<Employee> getList(){
		List<Employee> employeeList=new ArrayList<>();
		employeeList.addAll(this.employeeList.values());
		for(int i=0;i<employeeList.size();i++){
			Employee employee=employeeList.get(i);
			System.out.println(employee.getName()+" "+employee.getSurname());
		}
		return employeeList;
	}

}
