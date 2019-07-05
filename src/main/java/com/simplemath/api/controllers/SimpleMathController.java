package com.simplemath.api.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplemath.api.dtos.OperationDTO;
import com.simplemath.api.response.Response;
import com.simplemath.api.services.SimpleMathService;

@RestController
//@RequestMapping("/api/math")
@CrossOrigin(origins = "*")
public class SimpleMathController {

	private static final Logger log = LoggerFactory.getLogger(SimpleMathController.class);
	
	//@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@GetMapping(name = "/api/math", produces = "application/json")
	public String execute(	@RequestParam(name = "a", required = true) String a, 
							@RequestParam(name = "b", required = true) String b, 
							@RequestParam(name = "operation", required = true) String operation,
							@RequestParam(name="step", defaultValue = "UNITY") String step) {
		
		try {
			log.info("Request: [a, b, operation, step] -> [{}, {}, {}, {}]", a, b, operation, step);
			OperationDTO dto = new OperationDTO(a, b, operation, step);
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
	
}