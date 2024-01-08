package com.jimrennie.junit.worldone;

import org.junit.jupiter.api.*;

/**
 * 1.1 Lifecycle hooks
 */
class TestWorldOneLevel1 {

	/**
	 * Instructions:
	 * These are all the lifecycle hooks in Junit5. Run all the tests and observe the logs to understand how these
	 * lifecycle hooks work.
	 */

	TestWorldOneLevel1() {
		System.out.println("constructor");
	}

	@BeforeAll
	static void beforeAll() {
		System.out.println("beforeAll");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("afterAll");
	}

	@BeforeEach
	void setUp() {
		System.out.println("beforeEach");
	}

	@AfterEach
	void tearDown() {
		System.out.println("afterEach");
	}

	@Test
	void test1() {
		System.out.println("test1");
	}

	@Test
	void test2() {
		System.out.println("test2");
	}

	@Test
	@Disabled("The world isn't ready for this test")
	void test3() {
		System.out.println("test3");
	}

}
