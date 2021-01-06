package com.kmne68.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kmne68.aopdemo.dao.AccountDAO;
import com.kmne68.aopdemo.dao.MembershipDAO;


public class AfterFinallyDemoApp {
	

	public static void main(String[] args) {
		

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find the accounts
		List<Account> accounts = null;
		
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		}
		catch(Exception e) {
			System.out.println("\n\nMain Program...caught exception: " + e);
		}
		
		// display the accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("-----");
		
		System.out.println(accounts);
		
		System.out.println("\n");
		
		
		// close the context
		context.close();

	}

}
