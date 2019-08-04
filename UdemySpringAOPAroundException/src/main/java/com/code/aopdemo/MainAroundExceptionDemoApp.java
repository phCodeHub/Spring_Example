package com.code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aopdemo.service.TrafficFortuneService;

public class MainAroundExceptionDemoApp {
	
	
	private static Logger logger = Logger.getLogger(MainAroundExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		TrafficFortuneService lFortuneService= ctx.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		
		logger.info("Main Around Prog Starts!!!!!!!!!!!");
		
		logger.info("Call get Fortune!!!!!!!!!!!");
		
		boolean tripWire = true;
		
		String data = lFortuneService.getFortune(tripWire);
		
		logger.info("Fortune is --"+data);
		
		
		
		ctx.close();
		
		
	}

}
