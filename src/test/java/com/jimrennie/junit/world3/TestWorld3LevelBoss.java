package com.jimrennie.junit.world3;

import com.jimrennie.junit.world3.controller.StudentController;
import com.jimrennie.junit.world3.integration.EmailServer;

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
class TestWorld3LevelBoss {

}
