package com.code.mvcdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {
	
	private String coursePrefix;
	public void initialize(CourseCode arg0) {
		coursePrefix=arg0.value();
	}
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		boolean result = true;
				if(value!=null)
				result = value.startsWith(coursePrefix);
		
		return result;
	}

}
