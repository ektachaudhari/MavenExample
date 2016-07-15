package com.project.mavenexample.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.project.mavenexample.bdo.EmployeeBDO;

@Path("/employee")
public class EmployeeController {
	
	//private @Context HttpServletRequest httpRequest;	
	EmployeeBDO employeeBDO = new EmployeeBDO();

	/* add employee */
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@FormParam("name") String name, @FormParam("surname") String surname) {
		try {
			String responseData = employeeBDO.createEmployeeDetail(name, surname);
			return Response.ok(responseData).build();
		} catch (Exception ex) {
			ex.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}

	/* update employee */
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(String jsonString) {
		try {
			System.out.println("IN update method:: "+jsonString);
			String responseData = employeeBDO.updateEmployee(jsonString);
			System.out.println("after  update method:: "+jsonString);
			return Response.ok(responseData).build();
		} catch (Exception ex) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}

	}
	
	/* get employee list */

	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		try {
			String responseData = employeeBDO.getEmployeeList();
			System.out.println(responseData);
			return Response.ok(responseData).build();
		} catch (Exception ex) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}

	}

	/* delete employee */
	@GET
	@Path("/remove/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		try {
			employeeBDO.deleteEmployee(id);
			return Response.status(200).build();
		} catch (Exception ex) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}

	

}
