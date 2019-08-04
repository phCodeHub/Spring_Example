package com.code.aopdemo;

public class Account {
	
	
	public Account() {
		
	}
	
	
	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}


	public Account(String name, String level) {
		this.name = name;
		this.level = level;
	}
	private String name;
	private String level;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

}
