package com.exception;

public class StudentEnrollmentException extends Exception {

	
	@Override
	public String getMessage() {
	
		return "Selected coursetype is not available for the given course";
	}
}
