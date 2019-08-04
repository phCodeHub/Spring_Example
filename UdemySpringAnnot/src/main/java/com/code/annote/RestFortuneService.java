package com.code.annote;

import org.springframework.stereotype.Component;

@Component

public class RestFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Its Rest Fortune";
	}

}
