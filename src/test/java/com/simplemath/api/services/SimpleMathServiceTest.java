package com.simplemath.api.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.simplemath.api.dtos.OperationDTO;
import com.simplemath.api.utils.OperationStep;
import com.simplemath.api.utils.OperationType;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SimpleMathServiceTest {

	private static final int A = 999;
	private static final int B = 888;
	
	@Test
	public void testValidOperation() {
		OperationDTO dto = new OperationDTO();
		dto.setA(String.valueOf(SimpleMathServiceTest.A));
		dto.setB(String.valueOf(SimpleMathServiceTest.B));
		dto.setOperationName(OperationType.SUM.name());
		dto.setStep(OperationStep.UNITY.name());
		
		SimpleMathService service = new SimpleMathService(dto);
		assertEquals(OperationType.SUM.name(), service.execute().getData().getOperationName());
	}
	
	@Test
	public void testInvalidOperation() {
		OperationDTO dto = new OperationDTO();
		dto.setA(String.valueOf(SimpleMathServiceTest.A));
		dto.setB(String.valueOf(SimpleMathServiceTest.B));
		dto.setOperationName("asdad");
		dto.setStep(OperationStep.UNITY.name());
		
		SimpleMathService service = new SimpleMathService(dto);
		assertNotNull(service.execute().getErrors().get(0).startsWith("Invalid operation"));
	}
	
	@Test
	public void testNullOperation() {
		OperationDTO dto = new OperationDTO();
		dto.setA(String.valueOf(SimpleMathServiceTest.A));
		dto.setB(String.valueOf(SimpleMathServiceTest.B));
		dto.setOperationName(null);
		dto.setStep(OperationStep.UNITY.name());
		
		SimpleMathService service = new SimpleMathService(dto);
		assertNotNull(service.execute().getErrors().get(0).startsWith("Invalid operation"));
	}
	
	@Test
	public void testValidStep() {
		OperationDTO dto = new OperationDTO();
		dto.setA(String.valueOf(SimpleMathServiceTest.A));
		dto.setB(String.valueOf(SimpleMathServiceTest.B));
		dto.setOperationName(OperationType.SUM.name());
		dto.setStep(OperationStep.UNITY.name());
		
		SimpleMathService service = new SimpleMathService(dto);
		assertEquals(OperationStep.UNITY.name(), service.execute().getData().getStep());
	}
	
	@Test
	public void testInvalidStep() {
		OperationDTO dto = new OperationDTO();
		dto.setA(String.valueOf(SimpleMathServiceTest.A));
		dto.setB(String.valueOf(SimpleMathServiceTest.B));
		dto.setOperationName(OperationType.SUM.name());
		dto.setStep("asdads");
		
		SimpleMathService service = new SimpleMathService(dto);
		assertNotNull(service.execute().getErrors().get(0).startsWith("Invalid step"));
	}
	
	@Test
	public void testNullStep() {
		OperationDTO dto = new OperationDTO();
		dto.setA(String.valueOf(SimpleMathServiceTest.A));
		dto.setB(String.valueOf(SimpleMathServiceTest.B));
		dto.setOperationName(OperationType.SUM.name());
		dto.setStep(null);
		
		SimpleMathService service = new SimpleMathService(dto);
		assertNotNull(service.execute().getErrors().get(0).startsWith("Invalid step"));
	}
	
	@Test
	public void testSuccessExecution() {
		OperationDTO dto = new OperationDTO();
		dto.setA(String.valueOf(SimpleMathServiceTest.A));
		dto.setB(String.valueOf(SimpleMathServiceTest.B));
		dto.setOperationName(OperationType.SUM.name());
		dto.setStep(OperationStep.HUNDRED.name());
		
		SimpleMathService service = new SimpleMathService(dto);
		assertEquals(String.valueOf(1887), service.execute().getData().getResult());
	}
	
	@Test
	public void testErrorExecution() {
		OperationDTO dto = new OperationDTO();
		dto.setA(String.valueOf(SimpleMathServiceTest.A));
		dto.setB(String.valueOf(SimpleMathServiceTest.B));
		dto.setOperationName("asdads");
		dto.setStep("asdas");
		
		SimpleMathService service = new SimpleMathService(dto);
		assertNotNull(service.execute().getErrors());
	}
	
}