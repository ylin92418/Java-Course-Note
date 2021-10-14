package com.udacity.validator.strategies;

import com.udacity.domain.User;

@FunctionalInterface
public interface ValidationStrategy {
	boolean validateUser(User user);
}
