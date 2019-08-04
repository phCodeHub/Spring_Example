package com.code.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyTempAspect {
	
	@Before("com.code.aopdemo.aspects.AspectExpression.comboPointcut()")
	public void beforeAddAccountAdviceNew() {
		
		
		System.out.println("\n Exceuting @Before  new   temp\n");
	}

}
