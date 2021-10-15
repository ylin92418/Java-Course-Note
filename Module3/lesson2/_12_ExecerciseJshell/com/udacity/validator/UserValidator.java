package com.udacity.validator;

import com.udacity.domain.User;
import com.udacity.validator.strategies.ValidationStrategy;

public class UserValidator {

	private ValidationStrategy strategy;

	public boolean validateUser(User user) {
		if (strategy != null) {
			return strategy.validateUser(user);
		}

		return true;
	}

	public void setValidationStrategy(ValidationStrategy strategy) {
		this.strategy = strategy;
	}

}
