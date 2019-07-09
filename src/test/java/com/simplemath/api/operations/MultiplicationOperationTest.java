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
public class MultiplicationOperationTest {

	private static final int MINOR_A = 123;
	private static final int MINOR_B = 3;
	
	private static final int A = 456;
	private static final int B = 9;
	
	@Test
	public void testUnityOfSumOperators() {
		Operator a = new Operator(MultiplicationOperationTest.A);
		Operator b = new Operator(MultiplicationOperationTest.B);		
		Operation operation = new MultiplicationOperation(OperationStep.UNITY, a, b);
		
		assertEquals(String.valueOf(4), String.valueOf(operation.executeUnityStep().getUnity()));
		assertEquals(String.valueOf(5), String.valueOf(operation.executeUnityStep().getExtraUnity()));
	}
		
	@Test
	public void testDozenOfSumOperators() {
		Operator a = new Operator(MultiplicationOperationTest.A);
		Operator b = new Operator(MultiplicationOperationTest.B);		
		Operation operation = new MultiplicationOperation(OperationStep.DOZEN, a, b);
		
		assertEquals(String.valueOf(0), String.valueOf(operation.executeDozenStep().getDozen()));
		assertEquals(String.valueOf(5), String.valueOf(operation.executeDozenStep().getExtraDozen()));
	}
		
	@Test
	public void testHundredOfSumOperators() {
		Operator a = new Operator(MultiplicationOperationTest.A);
		Operator b = new Operator(MultiplicationOperationTest.B);		
		Operation operation = new MultiplicationOperation(OperationStep.HUNDRED, a, b);
		
		assertEquals(String.valueOf(41), String.valueOf(operation.executeHundredStep().getHundred()));
		assertEquals(String.valueOf(4), String.valueOf(operation.executeHundredStep().getExtraHundred()));
	}
	
	@Test
	public void testUnityOfSumOperatorOfMinorValues() {
		Operator a = new Operator(MultiplicationOperationTest.MINOR_A);
		Operator b = new Operator(MultiplicationOperationTest.MINOR_B);		
		Operation operation = new MultiplicationOperation(OperationStep.UNITY, a, b);
		
		assertEquals(String.valueOf(9), String.valueOf(operation.executeUnityStep().getUnity()));	
		assertNull(operation.executeUnityStep().getExtraUnity());
	}
	
	@Test
	public void testDozenOfSumOperatorOfMinorValues() {
		Operator a = new Operator(MultiplicationOperationTest.MINOR_A);
		Operator b = new Operator(MultiplicationOperationTest.MINOR_B);		
		Operation operation = new MultiplicationOperation(OperationStep.UNITY, a, b);
		
		assertEquals(String.valueOf(6), String.valueOf(operation.executeDozenStep().getDozen()));	
		assertNull(operation.executeDozenStep().getExtraDozen());
	}
	
	@Test
	public void testHundredOfSumOperatorOfMinorValues() {
		Operator a = new Operator(MultiplicationOperationTest.MINOR_A);
		Operator b = new Operator(MultiplicationOperationTest.MINOR_B);		
		Operation operation = new MultiplicationOperation(OperationStep.UNITY, a, b);
		
		assertEquals(String.valueOf(3), String.valueOf(operation.executeHundredStep().getHundred()));	
		assertNull(operation.executeHundredStep().getExtraHundred());
	}

}