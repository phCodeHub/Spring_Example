package com.code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.code.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount() {
		System.out.println(getClass() + ": Doing my JOb");
	}
	
	public void addAccount(Account lAccount) {
		System.out.println(getClass() + ": Doing my JOb with Account");
	}
	
	public void addAccount(Account lAccount,Boolean lVIP) {
		System.out.println(getClass() + ": Doing my JOb with Account with vip flag");
	}

}
