package com.code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aopdemo.dao.AccountDAO;

public class MainThrowingDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		AccountDAO lAccountDao = ctx.getBean("accountDAO",AccountDAO.class);
		
		List<Account> lAccountlist = null; 
				
				
		try {
			
			boolean tripwire = true;
			lAccountlist=lAccountDao.findAccounts(true);
		} catch (Exception e) {
			
			System.out.println("Main code excpt "+e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("After throwing App");
		
		System.out.println(lAccountlist);
		
		
		
		
		ctx.close();
		
		
	}

}
