package com.simplemath.api.dtos;


public class OperationDTO {

	private String a = null;
	private String b = null;
	private String operationName = null;
	private String step = null;
	private String nextStep = null;
	private String unity = null;
	private String dozen = null;
	private String hundred = null;
	private String extraUnity = null;
	private String extraDozen = null;
	private String extraHundred = null;
	private String result = null;
	
	public OperationDTO() {}
	
	public OperationDTO(String a, String b, String operationName, String step) {
		this.a = a;
		this.b = b;
		this.operationName = operationName;
		this.step = step;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}

	public String getDozen() {
		return dozen;
	}

	public void setDozen(String dozen) {
		this.dozen = dozen;
	}

	public String getHundred() {
		return hundred;
	}

	public void setHundred(String hundred) {
		this.hundred = hundred;
	}

	public String getExtraUnity() {
		return extraUnity;
	}

	public void setExtraUnity(String extraUnity) {
		this.extraUnity = extraUnity;
	}

	public String getExtraDozen() {
		return extraDozen;
	}

	public void setExtraDozen(String extraDozen) {
		this.extraDozen = extraDozen;
	}

	public String getExtraHundred() {
		return extraHundred;
	}

	public void setExtraHundred(String extraHundred) {
		this.extraHundred = extraHundred;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return 
				"{'Operation': [{"
					+ "'a': '" + a + 
					"', 'b': '" + b + 
					"', 'operationName': '" + operationName + 
					"', 'step': '" + step + 
					"', 'nextStep': '" + nextStep + 
					"', 'unity': '" + unity + 
					"', 'dozen': '" + dozen + 
					"', 'hundred': '" + hundred + 
					"', 'extraUnity': '" + extraUnity + 
					"', 'extraDozen': '" + extraDozen + 
					"', 'extraHundred': '" + extraHundred + 
					"', 'result': '" + result + 
				"}]}";
	}

}