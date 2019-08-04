package com.code.annote;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	private FortuneService lFortuneService;
	
	@Value("${foo.country}")	
	private String country;
	
	@Value("${foo.coachName}")
	private String coachName;

	public SwimCoach(FortuneService lFortuneService) {
		super();
		this.lFortuneService = lFortuneService;
	}

	public String getCountry() {
		return country;
	}

	public String getCoachName() {
		return coachName;
	}

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Swim in reverse";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return lFortuneService.getFortune();
	}

}
