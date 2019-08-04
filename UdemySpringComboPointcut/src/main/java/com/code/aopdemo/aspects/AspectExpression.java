package com.code.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectExpression {
	
	@Pointcut("execution(* com.code.aopdemo.dao.*.*(..))")//all method
	public void forDaoPackage() {}
	
	//for getter
	
	@Pointcut("execution(* com.code.aopdemo.dao.*.get*(..))")//all method
	public void getter() {}
	
	//for setter
	
	@Pointcut("execution(* com.code.aopdemo.dao.*.set*(..))")//all method
	public void setter() {}
	
	//combo pointcut
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")//all method
	public void comboPointcut() {}
	
	
	


}
