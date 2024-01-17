package com.jimrennie.junit.world3;

import com.jimrennie.junit.world3.core.Student;
import com.jimrennie.junit.world3.core.StudentNotificationService;
import com.jimrennie.junit.world3.integration.EmailServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * 1.1 Spring test setup
 *
 * Spring provides a comprehensive testing framework that integrates seamlessly with JUnit. Adding {@link SpringExtension}
 * to your test will initialize the Spring TestContext Framework, which manages the lifecycle of the Spring
 * ApplicationContext during test execution.
 *
 * Spring TestContext Framework allows you to add the following to your test:
 *
 * {@link ContextConfiguration} annotation enables you to configure the Spring ApplicationContext. A very handy attribute
 * when running tests is the {@link ContextConfiguration#classes()} attribute which allows you easily add Spring beans
 * to the ApplicationContext.
 *
 * {@link Autowired} annotation can be used to inject Spring beans into your test.
 *
 * {@link MockBean} and {@link SpyBean} annotation exist to enable mocking and spying on Spring beans using the mockito
 * framework.
 *
 * {@link SpringBootTest} annotation bootstraps your entire spring boot application.
 *
 * And much, much more...
 *
 *
 * Instructions:
 * {@link StudentNotificationService#sendMessage(Student, String)} is used to send emails using the
 * {@link EmailServer#send(String, String)}.
 *
 * Using the {@link SpringExtension}, make StudentNotificationService a Spring bean and test that it is passing the
 * correct email and message to the EmailServer. You aren't allowed to use @SpringBootTest for this one.
 *
 */
class TestWorld3Level1 {

	@Test
	void testEmailSentToServer() {
		// TODO
	}

}
