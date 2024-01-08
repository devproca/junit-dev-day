package com.jimrennie.junit.world1;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 1.5 Test templates
 *
 * Test templates are a powerful generalization of JUnit 5’s parameterized and repeated tests. See tests below for
 * exercise instructions.
 */
class TestWorld1Level5 {

	private final Random random = new Random();

	/**
	 * @RepeatedTest will run a test as many times as specified.
	 *
	 * Instructions:
	 * This test will only fail some of the time. Run the test 100 times using @RepeatedTest to prove that
	 * random.NextInt is not working as the developer of this test expects.
	 */
	@RepeatedTest(100)
	void testRandomNextInt_RandomNumberMaxOf4_ExpectRandomNumberToBeBetween0And6Exclusive() {
		int number = random.nextInt(0, 6);

		assertAll(
				() -> assertTrue(number < 6, "number[%s} < 6".formatted(number)),
				() -> assertTrue(number > 0, "number[%s] > 0".formatted(number))
		);
	}


	/**
	 * Parameterized tests make it possible to run a test multiple times with different parameters. They are declared
	 * just like a regular @Test method but use the @ParameterizedTest annotation instead. In addition, you must declare
	 * at least one data source that will provide the parameters for each test invocation.
	 *
	 * Additional reading:
	 * <a href="https://www.baeldung.com/parameterized-tests-junit-5">Baeldung parameterized tests</a>
	 *
	 * Instructions:
	 * The developer below doesn't know how to write parameterized tests. Refactor the below test into either one or two
	 * parameterized tests.
	 */

	// There are a lot of different ways to answer this question :)

	@ValueSource(strings = {" "})
	@NullAndEmptySource
	@ParameterizedTest
	void testStringUtilsIsBlank_BlankStrings_ExpectTrue(String input) {
		assertTrue(StringUtils.isBlank(input));
	}

	@ValueSource(strings = {"hi", " hi "})
	@ParameterizedTest
	void testStringUtilsIsBlank_NotBlankStrings_ExpectFalse(String input) {
		assertFalse(StringUtils.isBlank(input));
	}
}
