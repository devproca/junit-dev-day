package com.jimrennie.junit.world3.core;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidVerificationCodeException extends RuntimeException {

	public InvalidVerificationCodeException() {
		super("Invalid verification code");
	}

}
