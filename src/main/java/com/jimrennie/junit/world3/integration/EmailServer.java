package com.jimrennie.junit.world3.integration;

import org.springframework.stereotype.Service;

@Service
public class EmailServer {

	public void send(String emailAddress, String message) {
		throw new RuntimeException("Email server is sick today...");
	}

}
