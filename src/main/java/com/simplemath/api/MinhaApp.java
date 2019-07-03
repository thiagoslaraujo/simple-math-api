package com.simplemath.api;

import java.util.Arrays;

import com.simplemath.api.models.Operator;
import com.simplemath.api.operations.SumOperation;
import com.simplemath.api.utils.OperationStep;
import com.simplemath.api.utils.OperationType;

public class MinhaApp {

	public static void main(String[] args) {
		String op = "UNIT";
		//System.out.println(op.equalsIgnoreCase(OperationStep.UNITY.name()));
		
		String[] operations = { OperationType.SUM.name(), OperationType.SUB.name(), OperationType.MUL.name(), OperationType.DIV.name() };
		System.out.println(Arrays.asList(operations).contains("sum".toUpperCase()));
		System.out.println(OperationStep.valueOf("asd"));
	}

}
