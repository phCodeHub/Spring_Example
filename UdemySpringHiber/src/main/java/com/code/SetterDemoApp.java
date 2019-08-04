package com.code;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//load spring config file
				ClassPathXmlApplicationContext	 ctx = new ClassPathXmlApplicationContext("Beans.xml");
				
				//retrieve bean
				CricketCoach lCoach = ctx.getBean("myCricketCoach", CricketCoach.class);
				//call method on bean
				System.out.println("Spring workout is "+lCoach.getDailyWorkout());
				System.out.println("Daily fortune is "+lCoach.getDailyFortune());
				System.out.println("Email is "+lCoach.getEmailAddress());
				System.out.println("Team is "+lCoach.getTeam());
				System.out.println("Country is "+lCoach.getCountry());
				System.out.println("Coach Name is "+lCoach.getCoachName());
				
				//close the context
				ctx.close();

	}

}
