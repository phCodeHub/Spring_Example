package com.code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aopdemo.service.TrafficFortuneService;

public class MainAroundDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		TrafficFortuneService lFortuneService= ctx.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		
		System.out.println("Main Around Prog Starts!!!!!!!!!!!");
		
		System.out.println("Call get Fortune!!!!!!!!!!!");
		
		String data = lFortuneService.getFortune();
		
		System.out.println("Fortune is --"+data);
		
		
		
		ctx.close();
		
		
	}

}
