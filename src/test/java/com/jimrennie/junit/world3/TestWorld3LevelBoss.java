package com.jimrennie.junit.world3;

import com.jimrennie.junit.world3.controller.EmailVerificationCodeDto;
import com.jimrennie.junit.world3.controller.StudentController;
import com.jimrennie.junit.world3.controller.StudentDto;
import com.jimrennie.junit.world3.integration.EmailServer;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

/**
 * 3.boss
 *
 * You just finished building an email verification flow for students in the {@link StudentController} and now you need
 * to test it! Yay!
 *
 * The way the verification flow works is a request is sent in to the server for an existing student and a verification
 * code is sent to their email address using the {@link EmailServer}. A second request is sent in with the code that was
 * generated. If the code matches, the email os marked as verified on the student.
 *
 * Instructions:
 * - Test that a new student who starts the email verification flow is sent an email using the EmailServer and that the
 *   code sent to the email can be used to verify the email address.
 * - Test that if an invalid code is used, the email address will not be verified.
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
@Sql(scripts = "classpath:tear-down.sql", executionPhase = AFTER_TEST_METHOD)
class TestWorld3LevelBoss {

	@MockBean
	private EmailServer emailServer;
	@Captor
	private ArgumentCaptor<String> verificationCodeCaptor;
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testVerifyEmail_ValidVerificationCode_ExpectStudentToHaveEmailVerified() {
		String emailAddress = "winnie_the_pooh@tshirt.ca";
		ResponseEntity<StudentDto> createStudentResponse = restTemplate.postForEntity("/api/students", new StudentDto().setName("Mitch").setEmail(emailAddress), StudentDto.class);
		assertEquals(HttpStatus.CREATED, createStudentResponse.getStatusCode());
		assertNotNull(createStudentResponse.getBody());
		assertFalse(createStudentResponse.getBody().getEmailVerified());

		Long studentId = createStudentResponse.getBody().getStudentId();

		ResponseEntity<Void> sendEmailVerificationResponse = restTemplate.postForEntity("/api/students/%s/send-email-verification-code".formatted(studentId), null, Void.class);
		assertEquals(HttpStatus.OK, sendEmailVerificationResponse.getStatusCode());
		verify(emailServer).send(eq(emailAddress), verificationCodeCaptor.capture());

		String verificationCode = verificationCodeCaptor.getValue();

		ResponseEntity<Void> verifyEmailResponse = restTemplate.postForEntity("/api/students/%s/verify-email-verification-code".formatted(studentId), new EmailVerificationCodeDto().setCode(verificationCode), Void.class);
		assertEquals(HttpStatus.OK, verifyEmailResponse.getStatusCode());

		StudentDto student = restTemplate.getForObject("/api/students/" + studentId, StudentDto.class);
		assertTrue(student.getEmailVerified());
	}

	@Test
	void testVerifyEmail_InvalidVerificationCode_ExpectStudentToHaveEmailNotVerified() {
		String emailAddress = "chowder@sheeeesh.ca";
		ResponseEntity<StudentDto> createStudentResponse = restTemplate.postForEntity("/api/students", new StudentDto().setName("Vinney").setEmail(emailAddress), StudentDto.class);
		assertEquals(HttpStatus.CREATED, createStudentResponse.getStatusCode());
		assertNotNull(createStudentResponse.getBody());
		assertFalse(createStudentResponse.getBody().getEmailVerified());

		Long studentId = createStudentResponse.getBody().getStudentId();

		ResponseEntity<Void> sendEmailVerificationResponse = restTemplate.postForEntity("/api/students/%s/send-email-verification-code".formatted(studentId), null, Void.class);
		assertEquals(HttpStatus.OK, sendEmailVerificationResponse.getStatusCode());
		verify(emailServer).send(eq(emailAddress), verificationCodeCaptor.capture());

		String InvalidVerificationCode = verificationCodeCaptor.getValue() + "-invalid";

		ResponseEntity<Void> verifyEmailResponse = restTemplate.postForEntity("/api/students/%s/verify-email-verification-code".formatted(studentId), new EmailVerificationCodeDto().setCode(InvalidVerificationCode), Void.class);
		assertEquals(HttpStatus.BAD_REQUEST, verifyEmailResponse.getStatusCode());

		StudentDto student = restTemplate.getForObject("/api/students/" + studentId, StudentDto.class);
		assertFalse(student.getEmailVerified());
	}
}
