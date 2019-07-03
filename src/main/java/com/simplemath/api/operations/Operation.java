package com.simplemath.api.operations;

import com.simplemath.api.dtos.OperationDTO;
import com.simplemath.api.models.Operator;
import com.simplemath.api.utils.OperationStep;

public abstract class Operation {

	protected Operator a = null;
	protected Operator b = null;
	protected OperationStep step = null;
	protected OperationDTO operationDTO = null;
	
	public Operation(OperationStep operationStep, Operator a, Operator b) {
		this.a = a;
		this.b = b;
		this.step = operationStep;
		
		operationDTO = new OperationDTO();
		operationDTO.setStep(this.step.name());
		operationDTO.setA(String.valueOf(a.getValue()));
		operationDTO.setB(String.valueOf(b.getValue()));
	}
	
	public OperationDTO execute() {
		if(this.step == OperationStep.UNITY) {
			return executeUnityStep();
		
		} else if(this.step == OperationStep.DOZEN) {
			return executeDozenStep();
		
		} else if(this.step == OperationStep.HUNDRED) {
			return executeHundredStep();
			
		} else return null;
	}
	
	public OperationDTO getOperationDTO() {
		return this.operationDTO;
	}
	
	protected abstract OperationDTO executeUnityStep();
	
	protected abstract OperationDTO executeDozenStep();
	
	protected abstract OperationDTO executeHundredStep();
	
}