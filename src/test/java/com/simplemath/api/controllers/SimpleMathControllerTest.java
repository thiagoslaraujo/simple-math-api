package com.simplemath.api.controllers;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SimpleMathControllerTest {

	private static final int A = 765;
	private static final int B = 888;
	
	private static final String API = "/api/math/";
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testWithouA() throws Exception {
		String operation = "SUM";
		String step = "HUNDRED";
		mvc.perform(MockMvcRequestBuilders.get(
				SimpleMathControllerTest.API 
				+ "?b=" + SimpleMathControllerTest.B 
				+ "&operation=" + operation
				+ "&step=" + step
			).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testWithoutB() throws Exception {
		String operation = "SUM";
		String step = "HUNDRED";
		mvc.perform(MockMvcRequestBuilders.get(
				SimpleMathControllerTest.API 
				+ "?a=" + SimpleMathControllerTest.A 
				+ "&operation=" + operation
				+ "&step=" + step
			).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testWithoutAandB() throws Exception {
		String operation = "SUM";
		String step = "HUNDRED";
		mvc.perform(MockMvcRequestBuilders.get(
				SimpleMathControllerTest.API 
				+ "?operation=" + operation
				+ "&step=" + step
			).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
	}
		
	@Test
	public void testWithErrorValueForA() throws Exception {
		String operation = "SUM";
		String step = "HUNDRED";
		mvc.perform(MockMvcRequestBuilders.get(
				SimpleMathControllerTest.API 
				+ "?a=" + step 
				+ "b=" + SimpleMathControllerTest.B 
				+ "&operation=" + operation
				+ "&step=" + step
			).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());	
	}
	
	@Test
	public void testWithErrorValueForB() throws Exception {
		String operation = "SUM";
		String step = "HUNDRED";
		mvc.perform(MockMvcRequestBuilders.get(
				SimpleMathControllerTest.API 
				+ "?a=" + SimpleMathControllerTest.A 
				+ "b=" + operation
				+ "&operation=" + operation
				+ "&step=" + step
			).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testWithErrorValueForAandB() throws Exception {
		String operation = "SUM";
		String step = "HUNDRED";
		mvc.perform(MockMvcRequestBuilders.get(
				SimpleMathControllerTest.API 
				+ "?a=" + step 
				+ "b=" + operation 
				+ "&operation=" + operation
				+ "&step=" + step
			).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testWithoutOperation() throws Exception {
		String step = "HUNDRED";
		mvc.perform(MockMvcRequestBuilders.get(
				SimpleMathControllerTest.API 
				+ "?a=" + SimpleMathControllerTest.A 
				+ "b=" + SimpleMathControllerTest.B
				+ "&step=" + step
			).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testWithErrorValueForOperation() throws Exception {
		String step = "HUNDRED";
		mvc.perform(MockMvcRequestBuilders.get(
				SimpleMathControllerTest.API 
				+ "?a=" + SimpleMathControllerTest.A 
				+ "b=" + SimpleMathControllerTest.B
				+ "&operation=" + step
				+ "&step=" + step
			).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testWithErrorValueForStep() throws Exception {
		String operation = "SUM";
		String step = "HUNDRED";
		mvc.perform(MockMvcRequestBuilders.get(
				SimpleMathControllerTest.API 
				+ "?a=" + step 
				+ "b=" + operation 
				+ "&operation=" + operation
				+ "&step=" + operation
			).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testWithoutErrors() throws Exception {
		String operation = "SUM";
		String step = "HUNDRED";
		mvc.perform(MockMvcRequestBuilders.get(
				SimpleMathControllerTest.API 
				+ "?a=" + SimpleMathControllerTest.A 
				+ "&b=" + SimpleMathControllerTest.B 
				+ "&operation=" + operation
				+ "&step=" + step
			).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath(("$.data.unity"), equalTo("3")))
		.andExpect(jsonPath(("$.data.dozen"), equalTo("5")))
		.andExpect(jsonPath(("$.data.hundred"), equalTo("16")))
		.andExpect(jsonPath(("$.data.extraUnity"), equalTo("1")))
		.andExpect(jsonPath(("$.data.extraDozen"), equalTo("1")))
		.andExpect(jsonPath(("$.data.extraHundred"), equalTo("1")))
		.andExpect(jsonPath(("$.data.result"), equalTo("1653")))
		.andExpect(jsonPath(("$.data.a"), equalTo("765")))
		.andExpect(jsonPath(("$.data.b"), equalTo("888")))
		.andExpect(jsonPath(("$.data.operationName"), equalTo("SUM")))
		.andExpect(jsonPath(("$.data.step"), equalTo("HUNDRED")))
		.andExpect(jsonPath(("$.data.nextStep"), equalTo("HUNDRED")))
		.andExpect(jsonPath("$.errors").isEmpty());
	}
	
}