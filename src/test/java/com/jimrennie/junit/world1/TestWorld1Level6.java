package com.jimrennie.junit.world1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1.6 Using extensions
 *
 * JUnit's extensions provide a way to add extra functionality to the testing process beyond the standard annotations
 * and assertions provided by JUnit. They can be added to a test class using the @ExtendWith(class) annotation.
 *
 * See tests below for further instructions. As you do these exercises take a moment to look at the extension code you
 * are extending your test with.
 */
class TestWorld1Level6 {

	/**
	 * The {@link com.jimrennie.junit.world1.extension.JimRulesExtension} will resolve all String test method
	 * parameters to "Jim rules".
	 *
	 * Instructions:
	 * Extend this test class with the {@link com.jimrennie.junit.world1.extension.JimRulesExtension}. The assertion
	 * should pass once this is done.
	 */
	@Test
	void testIsParamJim(String value) {
		assertEquals("Jim rules", value);
	}

	/**
	 * The {@link com.jimrennie.junit.world1.extension.TimerExtension} will log the duration of the tests in the test
	 * class.
	 *
	 * Instructions:
	 * Extend this test class with the {@link com.jimrennie.junit.world1.extension.TimerExtension}. When you run all
	 * the tests, you should see a log message indicating the length of the test.
	 *
	 * Note:
	 * You can extend a test class with multiple extensions, so there is no need to remove the extension from the
	 * previous exercise.
	 */
	@Test
	void testSleepyMethod() throws Exception {
		Thread.sleep(250);
	}

}
