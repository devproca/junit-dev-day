package com.jimrennie.junit.world5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * 5.2 Hakuna matata extension
 *
 * You recently started working with a couple developers named Timon and Pumbaa. They quickly convince you of their
 * development philosophy known as "Hakuna Matata". Being the quick study that you are, you realize that you have been
 * worrying way too much about unit tests succeeding, and you know just what to do!
 *
 * Instructions:
 * Write an extension that makes every test pass and test it on this class
 */
class TestWorld5Level2 {

	@Test
	void test1() {
		fail("Sad broken test");
	}

	@Test
	void test2() {
		fail("Another sad broken test");
	}

	@Test
	void test3() {
		// Passing test
	}

}
