package com.kmne68.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	
	
	// add all our related advices
	
	
	// start with an @Before advice
	// @Before("execution(public void updateAccount())")
	// @Before("execution(public void addAccount())")
	// @Before("execution(public void com.kmne68.aopdemo.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	// @Before("execution(void add*())")
	
	// the following has a return type of "*" and matches on any method that begins with the string "add", 
	// will match on any number of arguments (..)
	// @Before("execution(* add*(com.kmne68.aopdemo.Account, ..))")
	// @Before("execution(* add*(..))")
	
	// return type = *
	// package = com.kmne68.aopdemo.dao
	// class = *
	// method = *
	// params = ..
	@Before("execution(* com.kmne68.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n======>>> Executing @Before advice on addAccount()");
		
	}

}
