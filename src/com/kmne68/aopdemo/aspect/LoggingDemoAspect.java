package com.kmne68.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.kmne68.aopdemo.Account;


@Aspect
@Component
@Order(2)
public class LoggingDemoAspect {
	
	
	@Around("execution(* com.kmne68.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// print the method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @Around on method: " + method);
		
		// get beginning time stamp
		long begin = System.currentTimeMillis();
		
		// execute the method
		Object result = proceedingJoinPoint.proceed();
		
		// get the ending time stamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		System.out.println("\n=====>>> Duration: " + duration / 1000 + " seconds");
		
		return result;
	}
	
	
	@After("execution(* com.kmne68.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		
		// print which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Excecuting @After (finally) on method: " + method );		
		
	}

	
	@AfterThrowing(
			pointcut="execution(* com.kmne68.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="exception")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exception) {
		
		// print which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Excecuting @AfterThrowing on method: " + method );
		
		// log the exception
		System.out.println("\n=====>>>The exception is: " + exception );
	}
	
	@AfterReturning(
			pointcut="execution(* com.kmne68.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n=====>>> result is: " + result);
		
		// post-process the data, modify it
		// convert the account names to uppercase
		convertAccountNamesToUppercase(result);
		
		System.out.println("\n=====>>> result is: " + result);
	
	}
	
	
	private void convertAccountNamesToUppercase(List<Account> result) {
		
		for(Account account : result) {
			String name = account.getName().toUpperCase();
			account.setName(name);
		}		
		
	}


	@Before("com.kmne68.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		
		System.out.println("\n======>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: " + methodSignature);
		
		// display method arguments
		Object[] args = joinPoint.getArgs();
		
		// loop through the args
		for(Object arg : args) {
			
			System.out.println(arg);
			
			if(arg instanceof Account) {
				// downcast and print Account specific stuff
				Account account = (Account) arg;
				
				System.out.println("account name: " + account.getName());
				System.out.println("account level: " + account.getLevel());
			}
		}
		
	}
	

	
	

}
