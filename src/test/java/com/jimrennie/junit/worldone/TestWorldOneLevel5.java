package com.jimrennie.junit.worldone;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 1.5 Test templates
 */
class TestWorldOneLevel5 {

	private final Random random = new Random();

	/**
	 * @RepeatedTest will run a test as many times as specified.
	 *
	 * Instructions:
	 * This test will only fail some of the time. Run the test 100 times using @RepeatedTest to prove that
	 * random.NextInt is not working as the developer of this test expects.
	 */
//	@Test
	// TODO Answer
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
	 * Additional information:
	 * <a href="https://www.baeldung.com/parameterized-tests-junit-5">Baeldung parameterized tests</a>
	 *
	 * Instructions:
	 * The developer below doesn't know how to write parameterized tests. Refactor the below test into either one or two
	 * parameterized tests.
	 */
	@Test
	void testStringUtilsIsBlank() {
		List<Pair<String, Boolean>> inputAndExpectedResults = List.of(
				Pair.of("", true),
				Pair.of(" ", true),
				Pair.of(null, true),
				Pair.of("hi", false),
				Pair.of(" hi ", false)
		);

		for (var inputAndExpectedResult : inputAndExpectedResults) {
			boolean expectedResult = inputAndExpectedResult.getRight();
			boolean actualResult = StringUtils.isBlank(inputAndExpectedResult.getLeft());
			assertEquals(expectedResult, actualResult);
		}
	}
}
