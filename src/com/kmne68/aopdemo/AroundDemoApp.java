package com.kmne68.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kmne68.aopdemo.dao.AccountDAO;
import com.kmne68.aopdemo.dao.MembershipDAO;
import com.kmne68.aopdemo.service.TrafficFortuneService;


public class AroundDemoApp {
	

	public static void main(String[] args) {
		

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain Program: ArrounemoApp");
		
		System.out.println("Calling getFortune");
		
		String data = trafficFortuneService.getFortune();
		
		System.out.println("\nThe traffic report: " + data);
		
		System.out.println("Finished");
		
		// close the context
		context.close();

	}

}
