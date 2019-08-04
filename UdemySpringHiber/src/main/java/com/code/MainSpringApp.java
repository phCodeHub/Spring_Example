package com.code;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//load spring config file
		ClassPathXmlApplicationContext	 ctx = new ClassPathXmlApplicationContext("Beans.xml");
		
		//retrieve bean
		Coach lCoach = ctx.getBean("myCoach", Coach.class);
		//call method on bean
		System.out.println("Spring workout is "+lCoach.getDailyWorkout());
		System.out.println("Daily fortune is "+lCoach.getDailyFortune());
		
		//close the context
		ctx.close();

	}

}
