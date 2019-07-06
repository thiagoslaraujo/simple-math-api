package com.simplemath.api.controllers;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplemath.api.dtos.OperationDTO;
import com.simplemath.api.response.Response;
import com.simplemath.api.services.SimpleMathService;
import com.simplemath.api.utils.OperationType;

@RestController
@CrossOrigin(origins = "*")
@Validated
public class SimpleMathController {

	private static final Logger log = LoggerFactory.getLogger(SimpleMathController.class);
	private static final String[] OPERATIONS = { OperationType.SUM.name(), OperationType.SUB.name(), OperationType.MUL.name(), OperationType.DIV.name() };
	
	/*
	@GetMapping(name = "/api/math", produces = "application/json")
	public String execute(	@RequestParam(name = "a", required = true) String a, 
							@RequestParam(name = "b", required = true) String b, 
							@RequestParam(name = "operation", required = true) String operation,
							@RequestParam(name="step", defaultValue = "UNITY") String step) {
		
		try {
			OperationDTO dto = new OperationDTO(a, b, operation, step);
			log.info("Request: {}", dto);
			
			SimpleMathService service = new SimpleMathService(dto);
			
			String response = new ObjectMapper().writeValueAsString(service.execute());
			log.info("Response: {}", response);
			
			return response;
			
		} catch (IOException e) {
			log.error("Error: {}", e);
        }
			
		Response<OperationDTO> data = new Response<>();
		data.getErrors().add("general.error");
		return data.getErrors().toString();
	}
	*/
	
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
			String operation,
			@RequestParam(name="step", defaultValue = "UNITY") String step
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