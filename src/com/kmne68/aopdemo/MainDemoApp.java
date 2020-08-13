package com.kmne68.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kmne68.aopdemo.dao.AccountDAO;
import com.kmne68.aopdemo.dao.MembershipDAO;


public class MainDemoApp {
	

	public static void main(String[] args) {
		

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from the spring container
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		
		// call the business method a second time for demo purposes
		Account account = new Account();
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
		accountDAO.goToSleep();
		membershipDAO.addMember();
		
		
		// call the membership business method
		membershipDAO.addAccount();
		
		
		// close the context
		context.close();

	}

}
