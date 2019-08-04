package com.code;

public class BaseballCoach implements Coach {
	
	
	private FortuneService lFortuneService;

	public BaseballCoach(FortuneService lFortuneService) {
		super();
		this.lFortuneService = lFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Get to do some batting";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return lFortuneService.getFortune();
	}

}
