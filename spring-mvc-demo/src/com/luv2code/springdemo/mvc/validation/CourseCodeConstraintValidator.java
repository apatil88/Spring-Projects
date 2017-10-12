package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode){
		coursePrefix = theCourseCode.value();               //Value defined in the CourseCode annotation "value" attribute
	}
	
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {  //theCode parameters refers to the form data entered by the user on the HTML form
		
		boolean result;   //Check to see of the course code entered by the user starts with the prefix "LUV"
		
		if(theCode != null){
			result = theCode.startsWith(coursePrefix);
		} else {
			result = true;
		}
		return result;
	}

}
