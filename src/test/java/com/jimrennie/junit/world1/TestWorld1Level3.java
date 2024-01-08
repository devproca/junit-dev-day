package com.jimrennie.junit.world1;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

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
 * Go through each test and add the appropriate assertion based on the test name.
 *
 * The tests are written in the format:
 * testMethodName_StateUnderTest_ExpectedBehavior
 */
class TestWorld1Level3 {

	@Test
	void testStringUtilsIsBlank_StringIsNotBlank_ExpectFalse() {
		boolean result = StringUtils.isBlank("asdf");

		// TODO add assertion
	}

	@Test
	void testStringUtilsIsBlank_StringIsBlank_ExpectTrue() {
		boolean result = StringUtils.isBlank("       ");

		// TODO add assertion
	}

	@Test
	void testStringUtilsTrimToNull_StringIsBlank_ExpectNull() {
		String result = StringUtils.trimToNull("   ");

		// TODO add assertion
	}

	@Test
	void testStringUtilsTrimToEmpty_StringIsBlank_ExpectNotNull() {
		String result = StringUtils.trimToEmpty("   ");

		// TODO add assertion
	}

	@Test
	void testStringUtilsTrimToEmpty_StringIsBlank_ExpectEmptyString() {
		String result = StringUtils.trimToEmpty("   ");

		// TODO add assertion
	}

	@Test
	void testStringUtilsTrimToNull_StringHasSpacesOnOutside_ExpectWhitespaceRemovedFromOutside() {
		String result = StringUtils.trimToNull("  hello world      ");

		// TODO add assertion
	}

	@Test
	void testStringUtilsTruncate_InvalidMaxWidth_ExpectIllegalArgumentException() {
		StringUtils.truncate("asdf", -1);

		// TODO add assertion
	}

	@Test
	void testSleepForFiveSeconds_RunMethod_ExpectNoLongerThanSixSeconds() {
		// TODO remove assertion
		Sleep.forFiveSeconds();

		// TODO add assertion
	}

	@Test
	void testNewUuid_TwoShouldNeverBeTheSame_ExpectNotEqual() {
		UUID uuid1 = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();

		// TODO add assertion
	}

	@Test
	void testStringUtilsSplit_HelloString_ExpectWordsSplit() {
		String[] result = StringUtils.split("hello world");

		String[] expectedResult = new String[]{"hello", "world"};

		// TODO add assertion
	}

	@Test
	void testCollectionsSort_ThreeUnorderedNumbers_ExpectSorted() {
		List<Integer> numbers = new ArrayList<>(List.of(5, 3, 1));

		Collections.sort(numbers);

		List<Integer> expectedResult = List.of(1, 3, 5);

		// TODO add assertion
	}

}
