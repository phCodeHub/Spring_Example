package com.code.annote;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("TennisWala")
//@Scope("prototype")
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService lFortuneService;
	
	public FortuneService getlFortuneService() {
		return lFortuneService;
	}
	//Setter Autowiring
	/*@Autowired
	public void setlFortuneService(FortuneService lFortuneService) {
		this.lFortuneService = lFortuneService;
	}
*/
	public TennisCoach() {
		System.out.println("inside default");
	}
	
	/*@Autowired
	public TennisCoach(FortuneService lFortuneService) {
		super();
		this.lFortuneService = lFortuneService;
	}*/

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice Service";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return lFortuneService.getFortune();
	}
	//Method Autowiring -- wiil be called at startup
	@Autowired
	@Qualifier("restFortuneService")
	public void yourFortune(FortuneService lFortune)
	{
		System.out.println("your fortune aaa");
	}
	
	//define init
	@PostConstruct
	public void doStartup() {
		System.out.println("It boooottting");
	}
	
	//define destroy
	@PreDestroy
	public void doShutdown() {
		System.out.println("It shuttting");
	}

}
