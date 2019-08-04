package com.code.mvcdemo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.code.mvcdemo.validation.CourseCode;

public class Customer {
	
	private String firstName;
	
	@NotNull(message="is required")//Mandatory for string 
	@Size(min=1,message="kuch to dalo")
	private String lastName;
	
	
	@Min(value=0,message="must be greater than zero")
	@Max(value=10,message="must be less than ten")
	private Integer freePasses;//to have mandatory validation convert int to INteger and use @NotNull
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}",message="code invalid")//Patter Validation
	private String postalCode;
	
	@CourseCode(value="PUL", message="start with PUL")
	private String courseCode;
	
	
	
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
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}
