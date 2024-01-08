package com.jimrennie.junit.world1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1.2 Lifecycle hooks in action
 *
 * This test class is testing the Singleton class {@link Counter}. In this exercise you're going to be adding some
 * lifecycle hooks to get this test class working properly.
 *
 * Instructions:
 * 1. If you run any of these tests on their own they pass, but if you run them together, some will fail. Using a
 * lifecycle hook, make sure counter is reset before each test is run. When complete all your tests should pass.
 *
 * 2. Like a good camper, you should leave your environment in the same condition as when you arrived. Using a
 * lifecycle hook, make sure counter is reset after all your tests have run.
 */
class TestWorld1Level2 {

	private final Counter counter = Counter.getInstance();

	@Test
	void testCounterNext_CallNext_ExpectCountToBeOne() {
		counter.next();

		assertEquals(1, counter.getCount());
	}

	@Test
	void testCounterNext_CallNextTwoTimes_ExpectCountToBeTwo() {
		counter.next().next();

		assertEquals(2, counter.getCount());
	}

	@Test
	void testCounterNext_CallNextThreeTimes_ExpectCountToBeThree() {
		counter.next().next().next();

		assertEquals(3, counter.getCount());
	}
}
