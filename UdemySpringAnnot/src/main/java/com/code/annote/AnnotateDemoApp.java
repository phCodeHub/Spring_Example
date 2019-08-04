package com.code.annote;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotateDemoApp {

	public static void main(String[] args) {
		// Read Spring config
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		
		// get bean
		Coach lCoach = ctx.getBean("TennisWala", Coach.class);
		
		System.out.println("Workout is "+lCoach.getDailyWorkOut());
		
		System.out.println("Fortune  is "+lCoach.getDailyFortune());
		
		
		//close container
		ctx.close();

	}

}
