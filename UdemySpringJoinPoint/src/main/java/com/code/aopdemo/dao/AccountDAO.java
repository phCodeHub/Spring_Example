package com.code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.code.aopdemo.Account;

@Component
public class AccountDAO {
	
	
	private String accountName;
	private String serviceCode;
	
	public String getAccountName() {
		System.out.println(getClass() + ": Doing my getAccountName");
		return accountName;
	}

	public void setAccountName(String accountName) {
		System.out.println(getClass() + ": Doing my setAccountName");
		this.accountName = accountName;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": Doing my getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": Doing my setServiceCode");
		this.serviceCode = serviceCode;
	}

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
