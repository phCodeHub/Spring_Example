package com.code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.code.aopdemo.Account;

@Component
public class AccountDAO {
	
	
	private String accountName;
	private String serviceCode;
	
	
	public List<Account> findAccounts(){
		List<Account> pAccount = new ArrayList<Account>();
		
		Account temp1 = new Account("Pulkit","Platinum");
		Account temp2 = new Account("Pintu","Gold");
		Account temp3 = new Account("Deep","Diamond");
		
		pAccount.add(temp1);
		pAccount.add(temp2);
		pAccount.add(temp3);
		
		
		return pAccount;
	}
	
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
