package com.jimrennie.junit.world3.core;

import com.jimrennie.junit.world3.core.Student;
import com.jimrennie.junit.world3.integration.EmailServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentNotificationService {

	@Autowired
	private EmailServer emailServer;

	public void sendMessage(Student student, String message) {
		emailServer.send(student.getEmail(), message);
	}

}
