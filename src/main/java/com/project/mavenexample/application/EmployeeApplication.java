package com.project.mavenexample.application;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class EmployeeApplication extends Application{

	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> resources = new java.util.HashSet<>();
		resources.add( com.project.mavenexample.controller.EmployeeController.class);
		return resources;
		
	}
}
