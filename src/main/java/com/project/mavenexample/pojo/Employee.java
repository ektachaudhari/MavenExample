package com.project.mavenexample.pojo;

public class Employee {
  private int empid;
  private String name;
  private String surname;  
  
  public Employee(){}
  
  public Employee(int id,String name,String surname){
	  this.empid=id;
	  this.name=name;
	  this.surname=surname;
  }
  
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + empid;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	if (empid != other.empid)
		return false;
	return true;
}
  

}
