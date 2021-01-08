package com.kmne68.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kmne68.aopdemo.dao.AccountDAO;
import com.kmne68.aopdemo.dao.MembershipDAO;
import com.kmne68.aopdemo.service.TrafficFortuneService;


public class AroundHandleExceptionDemoApp {
	
	
	private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	

	public static void main(String[] args) {
		

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		logger.info("\nMain Program: ArroundDemoApp");
		
		logger.info("Calling getFortune");
		
		boolean tripWire = true;
		
		String data = trafficFortuneService.getFortune(tripWire);
		
		logger.info("\nThe traffic report: " + data);
		
		logger.info("Finished");
		
		// close the context
		context.close();
		logger.info("Closing " + context);
	}

}
