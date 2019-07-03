package com.simplemath.api.operations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.simplemath.api.models.Operator;
import com.simplemath.api.utils.OperationStep;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SumOperationsTest {

	private static final int A = 456;
	private static final int B = 999;
	
	@Test
	public void testUnityOfSumOperators() {
		Operator a = new Operator(SumOperationsTest.A);
		Operator b = new Operator(SumOperationsTest.B);		
		SumOperation operation = new SumOperation(OperationStep.UNITY, a, b);
		
		assertEquals(String.valueOf(5), String.valueOf(operation.executeUnityStep().getUnity()));
	}
	
	@Test
	public void testExtraUnityOfSumOperators() {
		Operator a = new Operator(SumOperationsTest.A);
		Operator b = new Operator(SumOperationsTest.B);		
		SumOperation operation = new SumOperation(OperationStep.UNITY, a, b);
		
		assertEquals(String.valueOf(1), String.valueOf(operation.executeUnityStep().getExtraUnity()));
	}
	
	@Test
	public void testDozenOfSumOperators() {
		Operator a = new Operator(SumOperationsTest.A);
		Operator b = new Operator(SumOperationsTest.B);		
		SumOperation operation = new SumOperation(OperationStep.DOZEN, a, b);
		
		assertEquals(String.valueOf(5), String.valueOf(operation.executeDozenStep().getDozen()));
	}
	
	@Test
	public void testExtraDozenOfSumOperators() {
		Operator a = new Operator(SumOperationsTest.A);
		Operator b = new Operator(SumOperationsTest.B);		
		SumOperation operation = new SumOperation(OperationStep.DOZEN, a, b);
		
		assertEquals(String.valueOf(1), String.valueOf(operation.executeDozenStep().getExtraDozen()));
	}
	
	@Test
	public void testHundredOfSumOperators() {
		Operator a = new Operator(SumOperationsTest.A);
		Operator b = new Operator(SumOperationsTest.B);		
		SumOperation operation = new SumOperation(OperationStep.HUNDRED, a, b);
		
		assertEquals(String.valueOf(14), String.valueOf(operation.executeHundredStep().getHundred()));
	}
	
	@Test
	public void testExtraHundredOfSumOperators() {
		Operator a = new Operator(SumOperationsTest.A);
		Operator b = new Operator(SumOperationsTest.B);		
		SumOperation operation = new SumOperation(OperationStep.HUNDRED, a, b);
		
		assertEquals(String.valueOf(1), String.valueOf(operation.executeHundredStep().getExtraHundred()));
	}
		
}