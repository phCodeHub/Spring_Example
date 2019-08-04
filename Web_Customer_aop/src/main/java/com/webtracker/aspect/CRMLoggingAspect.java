package com.webtracker.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.webtracker.demo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	
	@Pointcut("execution(* com.webtracker.demo.service.*.*(..))")
	private void forServicePackage() {}
	
	
	@Pointcut("execution(* com.webtracker.dao.*.*(..))")
	private void forDaoPackage() {}
	
	
	@Pointcut("forControllerPackage() || forServicePackage() ||forDaoPackage() ")
	private void forAppFlow() {}
	
	
	@Before("forAppFlow()")
	public void before(JoinPoint lJoinPoint) {
		logger.info("In @Before method--"+lJoinPoint.getSignature().toShortString());
		
		Object[] args = lJoinPoint.getArgs();
		
		for(Object temp : args) {
			logger.info("Argument "+temp);
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()",returning="result")
	public void afterReturn(JoinPoint lJoinPoint,Object result) {
		
		logger.info("In @AfterReturning method--"+lJoinPoint.getSignature().toShortString());
		
		logger.info("return value --->"+result);
		
	}
	
	

}
