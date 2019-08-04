package com.code;

public class CricketCoach implements Coach {
	
	private FortuneService lFortuneService;
	private String emailAddress;
	private String team;
	private String country;
	private String coachName;
	
	
	
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		System.out.println("Set Email");
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
		System.out.println("Set Team");
	}

	
	
	public void setlFortuneService(FortuneService lFortuneService) {
		this.lFortuneService = lFortuneService;
		System.out.println("Set fortune");
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public CricketCoach() {
		System.out.println("inside Cricket");
	}

	/*public CricketCoach(FortuneService lFortuneService) {
		super();
		this.lFortuneService = lFortuneService;
	}*/

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do Batting";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return lFortuneService.getFortune();
	}

}
