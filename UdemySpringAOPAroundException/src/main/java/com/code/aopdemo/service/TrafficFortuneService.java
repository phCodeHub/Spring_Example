package com.code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	
	
	public String getFortune() {
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "You will ROck!!!!!!!!!!!!!";
		
		
	}

	public String getFortune(boolean tripWire) {
		// TODO Auto-generated method stub
		if(tripWire)
			throw new RuntimeException("Its falling");
		return getFortune();
	}

}
