package com.code.mvcdemo;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	
	private LinkedHashMap<String,String> countryOp;
	
	private String favLanguage;
	
	private String[] operatingSys;
	
	
	public Student() {
		countryOp = new LinkedHashMap<>();
		countryOp.put("US", "USA");
		countryOp.put("FR", "FRANCE");
		countryOp.put("GR", "GERMANY");
		countryOp.put("IN", "INDIA");
		
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public LinkedHashMap<String, String> getCountryOp() {
		return countryOp;
	}


	public String getFavLanguage() {
		return favLanguage;
	}


	public void setFavLanguage(String favLanguage) {
		this.favLanguage = favLanguage;
	}


	public String[] getOperatingSys() {
		return operatingSys;
	}


	public void setOperatingSys(String[] operatingSys) {
		this.operatingSys = operatingSys;
	}
	
	
}
