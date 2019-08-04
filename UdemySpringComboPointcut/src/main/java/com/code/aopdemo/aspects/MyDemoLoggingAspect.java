package com.code.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	
	
	//@Before("execution(public void addAccount())") //called for any addaccount
	//@Before("execution(public void com.code.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(public void add*())") //called for any method start with add
	//@Before("execution(* add*(com.code.aopdemo.Account))") 
	
		
	
	@Before("com.code.aopdemo.aspects.AspectExpression.forDaoPackage()")
	public void beforeAddAccountAdvice() {
		
		
		System.out.println("\n Exceuting @Before \n");
	}
	
	

}
