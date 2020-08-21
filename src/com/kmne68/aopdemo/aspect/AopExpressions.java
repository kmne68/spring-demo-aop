package com.kmne68.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* com.kmne68.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.kmnet68.aopdemo.dao.*.get*(..) ) " )
	public void getter() {}
	
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.kmnet68.aopdemo.dao.*.set*(..) ) " )
	public void setter() {}
	
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter() ) " )
	public void forDaoPackageNoGetterSetter() {}
}
