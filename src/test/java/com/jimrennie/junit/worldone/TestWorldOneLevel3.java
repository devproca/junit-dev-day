package com.jimrennie.junit.worldone;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 1.3 Assertions
 *
 * Junit comes with a number of standard {@link org.junit.jupiter.api.Assertions}. In this exercise we are going to
 * be adding assertions to existing tests.
 *
 * Here are the most common Junit assertions:
 * assertEquals(expected, actual)
 * assertNotEquals(expected, actual)
 * assertTrue(actual)
 * assertFalse(actual)
 * assertNull(actual)
 * assertNotNull(actual)
 * assertThrow(expectedType, executable)
 * assertArrayEquals(expected, actual)
 * assertIterableEquals(expected, actual)
 * assertTimeout(timeout, executable)
 * assertTimeoutPreemptively(timeout, executable)
 *
 *
 * Instructions:
 * Go through each test and add the appropriate assertion(s) based on the test name.
 *
 * The tests are written in the format:
 * testMethodName_StateUnderTest_ExpectedBehavior
 */
class TestWorldOneLevel3 {

	/**
	 * Example
	 */
	@Test
	void testStringUtilsIsBlank_StringIsNotBlank_ExpectFalse() {
		boolean result = StringUtils.isBlank("asdf");

		assertFalse(result);
	}

	@Test
	void testStringUtilsIsBlank_StringIsBlank_ExpectTrue() {
		boolean result = StringUtils.isBlank("       ");

		// TODO
		assertTrue(result);
	}

	@Test
	void testStringUtilsTrimToNull_StringIsBlank_ExpectNull() {
		String result = StringUtils.trimToNull("   ");

		// TODO
		assertNull(result);
	}

	@Test
	void testStringUtilsTrimToEmpty_StringIsBlank_ExpectNotNull() {
		String result = StringUtils.trimToEmpty("   ");

		// TODO
		assertNotNull(result);
	}

	@Test
	void testStringUtilsTrimToEmpty_StringIsBlank_ExpectEmptyString() {
		String result = StringUtils.trimToEmpty("   ");

		// TODO
		assertEquals("", result);
	}

	@Test
	void testStringUtilsTrimToNull_StringHasSpacesOnOutside_ExpectWhitespaceRemovedFromOutside() {
		String result = StringUtils.trimToNull("  hello world      ");

		// TODO
		assertEquals("hello world", result);
	}

	@Test
	void testStringUtilsTruncate_InvalidMaxWidth_ExpectIllegalArgumentException() {
		// TODO remove assert throws for question
		assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate("asdf", -1));

		// TODO
	}

	@Test
	void testSleepForFiveSeconds_RunMethod_ExpectNoLongerThanSixSeconds() {
		// TODO remove assertion
		assertTimeoutPreemptively(Duration.ofSeconds(6000), Sleep::forFiveSeconds);

		// TODO
	}

	@Test
	void testNewUuid_TwoShouldNeverBeTheSame_ExpectNotEqual() {
		UUID uuid1 = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();

		assertNotEquals(uuid1, uuid2);
	}

	@Test
	void testStringUtilsSplit_HelloString_ExpectWordsSplit() {
		String[] result = StringUtils.split("hello world");

		String[] expectedResult = new String[]{"hello", "world"};
		// TODO
		assertArrayEquals(expectedResult, result);
	}

	@Test
	void testCollectionsSort_ThreeUnorderedNumbers_ExpectSorted() {
		List<Integer> numbers = new ArrayList<>(List.of(5, 3, 1));

		Collections.sort(numbers);

		List<Integer> expectedResult = List.of(1, 3, 5);

		//TODO
		assertIterableEquals(expectedResult, numbers);
	}

}
