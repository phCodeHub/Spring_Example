package com.code.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DriverApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			ObjectMapper om = new ObjectMapper();
			Student myStudent = om.readValue(new File("data/sample-lite.json"), Student.class);
			
			System.out.println("First Name-->"+myStudent.getFirstName());
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
