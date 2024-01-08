package com.jimrennie.junit.world1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 1.4 assertAll
 *
 * assertAll(executables...) allows us to run multiple assertions at once instead of stopping a test as soon as
 * the first assertion fails.
 *
 * Instructions:
 * 1. Run the test and notice the assertion error
 * 2. Wrap these assertions into an assertAll so that they all execute at once. Run the test and observe.
 * 3. It can be confusing which assertions failed. Add an identifiable message to each assertion and re-run the test.
 *
 */
class TestWorld1Level4 {

	@Test
	void testPerson_PersonIsSuperMan_ExpectNameToMatch() {
		Person person = new Person("Clark", "Kent");

		assertAll(
				() -> assertEquals("Super", person.firstName(), "firstName"),
				() -> assertEquals("Man", person.lastName(), "lastName"),
				() -> assertEquals("Super Man", person.displayName(), "displayName")
		);
	}

}
