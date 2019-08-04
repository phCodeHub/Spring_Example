package com.code;

public class TrackCoach implements Coach {
	
	private FortuneService lFortuneService;

	public TrackCoach(FortuneService lFortuneService) {
		super();
		this.lFortuneService = lFortuneService;
	}

	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run marathon";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "You are going to fly and "+lFortuneService.getFortune();
	}
	
	// add init method
	public void getStarted() {
		System.out.println("Winter is coming !!!!!!!!!!!!!");
	}
	
	// add destroy method

	public void shutUp() {
		System.out.println("Winter is gone!!!");
	}
}
