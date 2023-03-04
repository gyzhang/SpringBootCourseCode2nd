package com.example.legacy.listener;


import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class HelloListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("helloListener: ServletContext Initialized.");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("helloListener: ServletContext Destroyed.");
	}

}
