package com.code.annote;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.code.annote")
@PropertySource("classpath:Sports.properties")
public class SportConfig {

	
	// method name will be bean id
	@Bean
	public FortuneService sadFortune() {
		return new SadFortuneService();
	}
	
	@Bean
	public Coach swimCoach()
	{
		return new SwimCoach(sadFortune());
	}
	
}
