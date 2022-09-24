package com.dambroski.Springboottutorial.erro;

public class DepartmentNotFoundException extends Exception {
	
	public DepartmentNotFoundException() {
		
	}
	
	public DepartmentNotFoundException(String message) {
		super(message);
	}
	
	public DepartmentNotFoundException(String message,Throwable cause) {
		super(message,cause);
	}
	
	public DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message,cause,enableSuppression,writableStackTrace);
	}
	
	
}
