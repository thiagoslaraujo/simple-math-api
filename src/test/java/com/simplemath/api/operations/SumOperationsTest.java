package com.simplemath.api.operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

	private static final int MINOR_A = 123;
	private static final int MINOR_B = 123;
	
	private static final int A = 456;
	private static final int B = 999;
	
	@Test
	public void testUnityOfSumOperators() {
		Operator a = new Operator(SumOperationsTest.A);
		Operator b = new Operator(SumOperationsTest.B);		
		SumOperation operation = new SumOperation(OperationStep.UNITY, a, b);
		
		assertEquals(String.valueOf(5), String.valueOf(operation.executeUnityStep().getUnity()));
		assertEquals(String.valueOf(1), String.valueOf(operation.executeUnityStep().getExtraUnity()));
	}
		
	@Test
	public void testDozenOfSumOperators() {
		Operator a = new Operator(SumOperationsTest.A);
		Operator b = new Operator(SumOperationsTest.B);		
		SumOperation operation = new SumOperation(OperationStep.DOZEN, a, b);
		
		assertEquals(String.valueOf(5), String.valueOf(operation.executeDozenStep().getDozen()));
		assertEquals(String.valueOf(1), String.valueOf(operation.executeDozenStep().getExtraDozen()));
	}
		
	@Test
	public void testHundredOfSumOperators() {
		Operator a = new Operator(SumOperationsTest.A);
		Operator b = new Operator(SumOperationsTest.B);		
		SumOperation operation = new SumOperation(OperationStep.HUNDRED, a, b);
		
		assertEquals(String.valueOf(14), String.valueOf(operation.executeHundredStep().getHundred()));
		assertEquals(String.valueOf(1), String.valueOf(operation.executeHundredStep().getExtraHundred()));
	}
	
	@Test
	public void testUnityOfSumOperatorOfMinorValues() {
		Operator a = new Operator(SumOperationsTest.MINOR_A);
		Operator b = new Operator(SumOperationsTest.MINOR_B);		
		SumOperation operation = new SumOperation(OperationStep.UNITY, a, b);
		
		assertEquals(String.valueOf(6), String.valueOf(operation.executeUnityStep().getUnity()));	
		assertNull(operation.executeUnityStep().getExtraUnity());
	}
	
	@Test
	public void testDozenOfSumOperatorOfMinorValues() {
		Operator a = new Operator(SumOperationsTest.MINOR_A);
		Operator b = new Operator(SumOperationsTest.MINOR_B);		
		SumOperation operation = new SumOperation(OperationStep.UNITY, a, b);
		
		assertEquals(String.valueOf(4), String.valueOf(operation.executeDozenStep().getDozen()));	
		assertNull(operation.executeDozenStep().getExtraDozen());
	}
	
	@Test
	public void testHundredOfSumOperatorOfMinorValues() {
		Operator a = new Operator(SumOperationsTest.MINOR_A);
		Operator b = new Operator(SumOperationsTest.MINOR_B);		
		SumOperation operation = new SumOperation(OperationStep.UNITY, a, b);
		
		assertEquals(String.valueOf(2), String.valueOf(operation.executeHundredStep().getHundred()));	
		assertNull(operation.executeHundredStep().getExtraHundred());
	}
		
}