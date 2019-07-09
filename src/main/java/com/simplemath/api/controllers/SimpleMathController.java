package com.simplemath.api.controllers;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplemath.api.annotations.OperationStep;
import com.simplemath.api.annotations.OperationType;
import com.simplemath.api.dtos.OperationDTO;
import com.simplemath.api.response.Response;
import com.simplemath.api.services.SimpleMathService;

@RestController
@CrossOrigin(origins = "*")
@Validated
public class SimpleMathController {
	
	@GetMapping(name = "/api/math", produces = "application/json")
	public ResponseEntity<Response<OperationDTO>> execute(
			@RequestParam(name = "a", required = true) 
			@Range(min = 0, max = 999, message = "Operator 'a' must be between 0 and 999")
			@NotEmpty(message = "Operator 'a' cannot be empty") 
			String a, 
			@RequestParam(name = "b", required = true) 
			@Range(min = 0, max = 999, message = "Operator 'b' must be between 0 and 999")
			@NotEmpty(message = "Operator 'b' cannot be empty") 
			String b, 
			@RequestParam(name = "operation", required = true) 
			@NotEmpty(message = "Operation name cannot be empty") 
			@OperationType
			String operation,
			@OperationStep
			@RequestParam(name="step", defaultValue = "UNITY") 
			String step
			){
		
		OperationDTO request = new OperationDTO(a, b, operation, step);		
		SimpleMathService service = new SimpleMathService(request);
		Response<OperationDTO> response = service.execute();		
		if(!response.getErrors().isEmpty()) {
			return (ResponseEntity<Response<OperationDTO>>) ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
}