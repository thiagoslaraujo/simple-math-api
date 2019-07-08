package com.simplemath.api.annotations;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OperationStepValidator implements ConstraintValidator<OperationStep, String> {

	@Override
	public void initialize(OperationStep step) {
	}

	@Override
	public boolean isValid(String step, ConstraintValidatorContext cxt) {
		String[] STEPS = { com.simplemath.api.utils.OperationStep.UNITY.name(), com.simplemath.api.utils.OperationStep.DOZEN.name(), com.simplemath.api.utils.OperationStep.HUNDRED.name() };
		return Arrays.asList(STEPS).contains(step);
	}
}