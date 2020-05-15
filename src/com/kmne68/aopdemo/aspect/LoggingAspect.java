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
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n======>>> Executing @Before advice on addAccount()");
		
	}

}
