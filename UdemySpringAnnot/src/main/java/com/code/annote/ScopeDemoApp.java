package com.code.annote;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");

		// get bean
		Coach lCoach = ctx.getBean("TennisWala", Coach.class);
		
		Coach pCoach = ctx.getBean("TennisWala", Coach.class);

	//	System.out.println("Workout is "+lCoach.getDailyWorkOut());

		//System.out.println("Fortune  is "+lCoach.getDailyFortune());
		
		
		boolean result = (lCoach == pCoach);
		
		System.out.println("Equal "+result);
		
		
		System.out.println("Memory location lCoach"+lCoach);
		System.out.println("Memory location pCoach"+pCoach);


		//close container
		ctx.close();

	}

}
