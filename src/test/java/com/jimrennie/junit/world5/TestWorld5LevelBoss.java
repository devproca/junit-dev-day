package com.jimrennie.junit.world5;

import org.junit.jupiter.api.Test;

/**
 * 5.boss
 *
 * The database table you're testing uses a long as its primary key. You want the ability to inject a unique long into
 * your test, so you can stop worrying about creating unique ids and get to testing.
 *
 * Instructions:
 * Create an extension that injects a unique long as a parameter into the test. The long should be unique to this test
 * class, not all test classes.
 *
 * Hint:
 * You will need to use the data store in the extension context. The store is hierarchical so each test has a store and
 * the test class has a store.
 */
class TestWorld5LevelBoss {

	@Test
	void test1(Long id) {
		System.out.printf("test1 - id: %s%n", id);
	}

	@Test
	void test2(long id) {
		System.out.printf("test2 - id: %s%n", id);
	}

	@Test
	void test3(Long id1, long id2) {
		System.out.printf("test3 - id1: %s id2: %s%n", id1, id2);
	}

}
