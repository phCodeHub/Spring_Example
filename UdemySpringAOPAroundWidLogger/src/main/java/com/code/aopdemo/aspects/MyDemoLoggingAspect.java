package com.code.aopdemo.aspects;

import java.util.List;
import java.util.logging.Logger;

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

import com.code.aopdemo.Account;
import com.code.aopdemo.MainAroundLoggerDemoApp;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	
	
	//@Before("execution(public void addAccount())") //called for any addaccount
	//@Before("execution(public void com.code.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(public void add*())") //called for any method start with add
	//@Before("execution(* add*(com.code.aopdemo.Account))") 
	private static Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
		
	
	@Before("com.code.aopdemo.aspects.AspectExpression.forDaoPackage()")
	public void beforeAddAccountAdvice(JoinPoint pJoinPoint) {
		
		
		logger.info("\n Exceuting @Before \n");
		
		
		//display method sign
		MethodSignature lMethodSig = (MethodSignature)pJoinPoint.getSignature();
		
		logger.info("Sig -->"+lMethodSig);
		
		//display args
		
		
		Object[] args = pJoinPoint.getArgs();
		
		for(Object temp :args) {
			logger.info("arg -->"+temp);
			if(temp instanceof Account) {
				Account tAccount = (Account)temp;
				logger.info("Acc Name--"+tAccount.getName());
				logger.info("Acc Level--"+tAccount.getLevel());
			}
			
		}
	}
	
	@AfterReturning(pointcut="execution(* com.code.aopdemo.dao.AccountDAO.findAccounts(..))" ,returning="result")
	public void afterReturningFindAccountAdvice(JoinPoint pJoinpoint,List<Account> result) {
		
		//We can modify result also here
		
		String lMethodSig = pJoinpoint.getSignature().toShortString();
		
		logger.info("After returning Method sig --"+lMethodSig);
		
		
		logger.info("After returning Result --"+result);
		
		
		
		
	}
	
	
	@AfterThrowing(pointcut="execution(* com.code.aopdemo.dao.AccountDAO.findAccounts(..))" ,throwing="result")
	public void afterThrowingFindAccountAdvice(JoinPoint pJoinpoint,Throwable result) {
		
		//We can modify result also here
		
		String lMethodSig = pJoinpoint.getSignature().toShortString();
		
		logger.info("After throwing Method sig --"+lMethodSig);
		
		
		logger.info("After throwsing Result --"+result);
		
		
		
		
	}
	
	@After("execution(* com.code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAccountAdvice(JoinPoint pJoinpoint) {
		
		//We can modify result also here
		
		String lMethodSig = pJoinpoint.getSignature().toShortString();
		
		logger.info("After Method sig --"+lMethodSig);
		
		
	//	logger.info("After throwsing Result --"+result);
		
		
		
		
	}
	
	@Around("execution(* com.code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint pJoinpoint) throws Throwable {
		
		//We can modify result also here
		
		String lMethodSig = pJoinpoint.getSignature().toShortString();
		
		logger.info("After Method sig --"+lMethodSig);
		
		long begin = System.currentTimeMillis();
		
		Object result = pJoinpoint.proceed();
		
		
		long end = System.currentTimeMillis();
		
		
		logger.info("duration ==="+(end-begin));
		
		
		return result;
		
		
	//	logger.info("After throwsing Result --"+result);
		
		
		
		
	}
	
	
	

}
