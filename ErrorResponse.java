package com.Day2EmployeeProject.Exception;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {
	
	private String status;
	private String message;
	private Object details;
	
	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}

	public ErrorResponse(String status, String message, Object details) {
		super();
		this.status = status;
		this.message = message;
		this.details = details;
	}
	
}
