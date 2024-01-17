package com.jimrennie.junit.world3.core;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(long studentId) {
		super("StudentId[%s] not found".formatted(studentId));
	}

}
