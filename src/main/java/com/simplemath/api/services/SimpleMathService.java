package com.simplemath.api.services;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simplemath.api.dtos.OperationDTO;
import com.simplemath.api.models.Operator;
import com.simplemath.api.operations.SumOperation;
import com.simplemath.api.response.Response;
import com.simplemath.api.utils.OperationStep;
import com.simplemath.api.utils.OperationType;

public class SimpleMathService {

	private static final String[] OPERATIONS = { OperationType.SUM.name(), OperationType.SUB.name(), OperationType.MUL.name(), OperationType.DIV.name() };
	private static final String[] STEPS = { OperationStep.UNITY.name(), OperationStep.DOZEN.name(), OperationStep.HUNDRED.name() };

	private static final Logger log = LoggerFactory.getLogger(SimpleMathService.class);
	
	private OperationDTO dto = null;
	
	public SimpleMathService(OperationDTO dto) {
		this.dto = dto;
	}
	
	public Response<OperationDTO> execute() {
		Response<OperationDTO> response = new Response<>();
		
		if(!validateOperation()) {
			log.debug("Invalid operation: [{}]", this.dto.getOperationName());
			response.getErrors().add(String.format("Invalid operation: [%s]. Operations are: %s", this.dto.getOperationName(), Arrays.toString(OPERATIONS)));
		}
		
		if(!validateStep()) {
			log.debug("Invalid step: [{}]", this.dto.getStep());
			response.getErrors().add(String.format("Invalid step: [%s]. Steps are: %s", this.dto.getStep(), Arrays.toString(STEPS)));
		}
		
		if(validateOperation() && validateStep()) {
			log.debug("Valid data: {}", this.dto);
			
			String operation = this.dto.getOperationName();
			String step = this.dto.getStep();
			Operator a = new Operator(Integer.parseInt(this.dto.getA()));
			Operator b = new Operator(Integer.parseInt(this.dto.getB()));
			
			if(operation.equalsIgnoreCase(OperationType.SUM.name())) {
				response.setData(new SumOperation(OperationStep.valueOf(step),a,b).execute());
			
			} else if(operation.equalsIgnoreCase(OperationType.SUB.name())) {
				response.setData(new SumOperation(OperationStep.valueOf(step),a,b).execute());
			
			} else if(operation.equalsIgnoreCase(OperationType.MUL.name())) {
				response.setData(new SumOperation(OperationStep.valueOf(step),a,b).execute());
			
			} else if(operation.equalsIgnoreCase(OperationType.DIV.name())) {
				response.setData(new SumOperation(OperationStep.valueOf(step),a,b).execute());
			
			} else {
				response.getErrors().add("Ops, something went wrong!");
			}
			
			log.debug("Operation result: {}", response.getData());
			
		}
		
		return response;
	}
	
	public boolean validateOperation() {
		return Arrays.asList(OPERATIONS).contains(this.dto.getOperationName().toUpperCase());
	}
	
	public boolean validateStep() {
		return Arrays.asList(STEPS).contains(this.dto.getStep().toUpperCase());
	}
	
}