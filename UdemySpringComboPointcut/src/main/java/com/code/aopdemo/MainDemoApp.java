package com.code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aopdemo.dao.AccountDAO;
import com.code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		AccountDAO lAccountDao = ctx.getBean("accountDAO",AccountDAO.class);
		lAccountDao.addAccount();
		
		Account lAccount = new Account();
		lAccountDao.addAccount(lAccount );
		
		lAccountDao.addAccount(lAccount,true);
		
		lAccountDao.setAccountName("fOOBAR");
		lAccountDao.setServiceCode("HSN");
		
		lAccountDao.getAccountName();
		lAccountDao.getServiceCode();
		
		
		
		MembershipDAO lMembershipDAO = ctx.getBean("membershipDAO",MembershipDAO.class);
		lMembershipDAO.addAccount();
		
		
		
		ctx.close();
		
		
	}

}
