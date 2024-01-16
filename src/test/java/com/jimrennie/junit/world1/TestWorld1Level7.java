package com.jimrennie.junit.world1;

import org.junit.jupiter.api.*;

/**
 * 1.7 Nested test classes
 *
 * Nested classes allow you to organize your test code in a hierarchical manner. Nested classes can be used to group
 * related tests and provide a clear structure to your test suite by using the {@link Nested} annotation.
 *
 * Instructions:
 * This class has a nested test class. Run the test class and observe the logs to understand how the lifecycle hooks
 * work.
 */
class TestWorld1Level7 {

	TestWorld1Level7() {
		System.out.println("outer - constructor");
	}

	@BeforeAll
	static void beforeAll() {
		System.out.println("outer - beforeAll");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("outer - afterAll");
	}

	@BeforeEach
	void setUp() {
		System.out.println("outer - beforeEach");
	}

	@AfterEach
	void tearDown() {
		System.out.println("outer - afterEach");
	}

	@Test
	void outerTest1() {
		System.out.println("outer - test");
	}

	@Nested
	class TestWorld1Level7Nested {

		TestWorld1Level7Nested() {
			System.out.println("inner - constructor");
		}

		@BeforeAll
		static void beforeAll() {
			System.out.println("inner - beforeAll");
		}

		@AfterAll
		static void afterAll() {
			System.out.println("inner - afterAll");
		}

		@BeforeEach
		void setUp() {
			System.out.println("inner - beforeEach");
		}

		@AfterEach
		void tearDown() {
			System.out.println("inner - afterEach");
		}

		@Test
		void innerTest1() {
			System.out.println("inner - test");
		}

	}
}
