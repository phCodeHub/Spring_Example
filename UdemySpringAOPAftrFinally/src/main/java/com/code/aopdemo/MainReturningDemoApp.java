package com.code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aopdemo.dao.AccountDAO;

public class MainReturningDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		AccountDAO lAccountDao = ctx.getBean("accountDAO",AccountDAO.class);
		
		List<Account> lAccountlist = lAccountDao.findAccounts(false);
		
		System.out.println("After returning App");
		
		System.out.println(lAccountlist);
		
		
		
		
		ctx.close();
		
		
	}

}
