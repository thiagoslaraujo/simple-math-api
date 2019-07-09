package com.simplemath.api.operations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simplemath.api.dtos.OperationDTO;
import com.simplemath.api.models.Operator;
import com.simplemath.api.utils.OperationStep;

public class MultiplicationOperation extends Operation {

	private static final Logger log = LoggerFactory.getLogger(MultiplicationOperation.class);

	public MultiplicationOperation(OperationStep operationStep, Operator a, Operator b) {
		super(operationStep, a, b);
		operationDTO.setOperationName("MUL");
	}
	
	protected OperationDTO executeUnityStep() {
		int resultUnity = Integer.parseInt(this.a.getUnity()) * Integer.parseInt(this.b.getUnity());
		log.debug("Unity Step: {} + {} = {}", Integer.parseInt(this.a.getUnity()), Integer.parseInt(this.b.getUnity()), resultUnity);
		
		if(resultUnity > 9) {
			String valueUnity = String.valueOf(resultUnity);
			operationDTO.setExtraUnity(String.valueOf(valueUnity.charAt(valueUnity.length() - 2)));
			operationDTO.setUnity(String.valueOf(valueUnity.charAt(valueUnity.length() - 1)));	
			operationDTO.setNextStep(OperationStep.DOZEN.name());	
			log.debug("Result is greater than 9 [unity: {}, extraUnity: {}]", operationDTO.getUnity(), operationDTO.getExtraUnity());
		} else {
			operationDTO.setNextStep(OperationStep.DOZEN.name());
			operationDTO.setUnity(String.valueOf(resultUnity));
			log.debug("Result is less than or equals 9 [unity: {}]", operationDTO.getUnity());
		}
		operationDTO.setResult(operationDTO.getUnity());
		return operationDTO;
	}

	protected OperationDTO executeDozenStep() {
		operationDTO = executeUnityStep();
		
		int result = Integer.parseInt(this.a.getDozen()) * Integer.parseInt(this.b.getUnity()) ;
		if(operationDTO.getExtraUnity() != null) {
			result = result + Integer.parseInt(operationDTO.getExtraUnity()); 
		}	
		log.debug("Dozen Step: {} + {} + [extraUnity: {}] = {}", Integer.parseInt(this.a.getDozen()), Integer.parseInt(this.b.getDozen()), operationDTO.getExtraUnity(), result);
		
		if(result > 9) {
			String value = String.valueOf(result);
			operationDTO.setExtraDozen(String.valueOf(value.charAt(value.length() - 2)));
			operationDTO.setDozen(String.valueOf(value.charAt(value.length() - 1)));	
			operationDTO.setNextStep(OperationStep.HUNDRED.name());
			log.debug("Result is greater than 9 [dozen: {}, extraDozen: {}]", operationDTO.getDozen(), operationDTO.getExtraDozen());
		} else {
			operationDTO.setNextStep(OperationStep.HUNDRED.name());
			operationDTO.setDozen(String.valueOf(result));
			log.debug("Result is less than or equals 9 [dozen: {}]", operationDTO.getDozen());
		}
		operationDTO.setResult(operationDTO.getDozen() + operationDTO.getUnity());
		return operationDTO;
	}
	
	protected OperationDTO executeHundredStep() {
		operationDTO = executeDozenStep();

		int result = Integer.parseInt(this.a.getHundred()) * Integer.parseInt(this.b.getUnity()) ;
		if(operationDTO.getExtraDozen() != null) {
			result = result + Integer.parseInt(operationDTO.getExtraDozen()); 
		}	
		log.debug("Hundred Step: {} + {} + [extraDozen: {}] = {}", Integer.parseInt(this.a.getHundred()), Integer.parseInt(this.b.getHundred()), operationDTO.getExtraDozen(),  result);
		
		if(result > 9) {
			String value = String.valueOf(result);
			operationDTO.setExtraHundred(String.valueOf(value.charAt(value.length() - 2)));
			operationDTO.setHundred(String.valueOf(value));
			log.debug("Result is greater than 9 [hundred: {}, extraHundred: {}]", operationDTO.getHundred(), operationDTO.getExtraHundred());
		} else {
			operationDTO.setHundred(String.valueOf(result));
			log.debug("Result is less than or equals 9 [hundred: {}]", operationDTO.getHundred());
		}
		operationDTO.setResult(operationDTO.getHundred() + operationDTO.getDozen() + operationDTO.getUnity());
		return operationDTO;
	}
		
}