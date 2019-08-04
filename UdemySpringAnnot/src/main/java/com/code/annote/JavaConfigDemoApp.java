package com.code.annote;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// Read Spring config
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get bean
		Coach lCoach = ctx.getBean("TennisWala", Coach.class);
		
		System.out.println("Workout is "+lCoach.getDailyWorkOut());
		
		System.out.println("Fortune  is "+lCoach.getDailyFortune());
		
		
		//close container
		ctx.close();

	}

}
