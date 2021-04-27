package com.inminhouse.study.spring.ch07.quickstart;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if(StringUtils.isEmpty(user.getEmail()) || user.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		if(user.getAge() == 0) {
			errors.rejectValue("age", "tooyoung");
		}
		if(user.getAge() == 0) {
			errors.rejectValue("age", "tooold");
		}
	}

}
