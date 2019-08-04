package com.code.aopdemo.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.code.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	
	
	//@Before("execution(public void addAccount())") //called for any addaccount
	//@Before("execution(public void com.code.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(public void add*())") //called for any method start with add
	//@Before("execution(* add*(com.code.aopdemo.Account))") 
	
		
	
	@Before("com.code.aopdemo.aspects.AspectExpression.forDaoPackage()")
	public void beforeAddAccountAdvice(JoinPoint pJoinPoint) {
		
		
		System.out.println("\n Exceuting @Before \n");
		
		
		//display method sign
		MethodSignature lMethodSig = (MethodSignature)pJoinPoint.getSignature();
		
		System.out.println("Sig -->"+lMethodSig);
		
		//display args
		
		
		Object[] args = pJoinPoint.getArgs();
		
		for(Object temp :args) {
			System.out.println("arg -->"+temp);
			if(temp instanceof Account) {
				Account tAccount = (Account)temp;
				System.out.println("Acc Name--"+tAccount.getName());
				System.out.println("Acc Level--"+tAccount.getLevel());
			}
			
		}
	}
	
	@AfterReturning(pointcut="execution(* com.code.aopdemo.dao.AccountDAO.findAccounts(..))" ,returning="result")
	public void afterReturningFindAccountAdvice(JoinPoint pJoinpoint,List<Account> result) {
		
		//We can modify result also here
		
		String lMethodSig = pJoinpoint.getSignature().toShortString();
		
		System.out.println("After returning Method sig --"+lMethodSig);
		
		
		System.out.println("After returning Result --"+result);
		
		
		
		
	}
	
	
	

}
