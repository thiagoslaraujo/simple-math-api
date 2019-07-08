package com.simplemath.api.annotations;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OperationTypeValidator implements ConstraintValidator<OperationType, String> {

	@Override
	public void initialize(OperationType type) {
	}

	@Override
	public boolean isValid(String type, ConstraintValidatorContext cxt) {
		String[] OPERATIONS = { com.simplemath.api.utils.OperationType.SUM.name(), com.simplemath.api.utils.OperationType.SUB.name(), com.simplemath.api.utils.OperationType.MUL.name(), com.simplemath.api.utils.OperationType.DIV.name() };
		return Arrays.asList(OPERATIONS).contains(type);
	}
}