package com.Day2EmployeeProject.Exception;

import lombok.experimental.SuperBuilder;

public class ResourceNotFoundException extends RuntimeException{
	
	 public ResourceNotFoundException(String message) {
		 super(message);
	}

}
