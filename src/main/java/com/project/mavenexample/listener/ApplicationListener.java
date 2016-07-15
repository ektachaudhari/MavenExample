package com.project.mavenexample.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.project.mavenexample.datastore.EmployeeDAO;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
public class ApplicationListener implements ServletContextListener {

	public ApplicationListener() {
	}

	public void contextInitialized(ServletContextEvent arg0) {
		EmployeeDAO.getInstance().init();
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		EmployeeDAO.getInstance().destroy();
	}

}
