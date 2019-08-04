package com.code;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//load spring config file
		ClassPathXmlApplicationContext	 ctx = new ClassPathXmlApplicationContext("Beans_Scope.xml");
		
		//retrieve bean
		Coach lCoach = ctx.getBean("myCoach", Coach.class);
		
		Coach lAlphaCoach = ctx.getBean("myCoach", Coach.class);
		//call method on bean
		System.out.println("Spring workout is "+lCoach.getDailyWorkout());
		System.out.println("Daily fortune is "+lCoach.getDailyFortune());
		
		
		boolean compare = (lCoach == lAlphaCoach );
		
		System.out.println("Result is "+compare);
		System.out.println("location is lCoach  "+lCoach);
		System.out.println("location is lAlphaCoach  "+lAlphaCoach);
		
		
		//close the context
		ctx.close();
	}

}
