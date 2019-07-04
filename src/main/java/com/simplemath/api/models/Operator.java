package com.simplemath.api.models;

/**
 * @author Thiago Araújo
 *
 */
public class Operator {
	
	private String value = null;
	
	public Operator(int value) {
		this.value = String.format("%03d", value);
	}
	
	public int getValue() {
		return Integer.valueOf(this.value);
	}
	
	public String getUnity() {
		if(value.length() == 1) {
			return String.valueOf(value.charAt(0));
		
		} else if(value.length() > 1) {
			return String.valueOf(value.charAt(value.length() - 1));
		
		} else return null;
	}
	
	public String getDozen() {
		if(value.length() == 2) {
			return String.valueOf(value.charAt(0));
		
		} else if(value.length() > 2) {
			
			return String.valueOf(value.charAt(value.length() - 2));
		} else return null;
	}
	
	public String getHundred() {
		if(value.length() == 3) {
			return String.valueOf(value.charAt(0));
		
		} else if(value.length() > 3) {
			return String.valueOf(value.charAt(value.length() - 3));
		
		} else return null;
	}

}