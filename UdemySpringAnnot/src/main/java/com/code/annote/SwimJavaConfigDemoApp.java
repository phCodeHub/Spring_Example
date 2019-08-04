package com.code.annote;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// Read Spring config
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get bean
		SwimCoach lCoach = ctx.getBean("swimCoach", SwimCoach.class);
		
		System.out.println("Workout is "+lCoach.getDailyWorkOut());
		
		System.out.println("Fortune  is "+lCoach.getDailyFortune());
		
		
		System.out.println("Country -- "+lCoach.getCountry());
		
		System.out.println("Coach Name -- "+lCoach.getCoachName());
		
		
		//close container
		ctx.close();

	}

}
