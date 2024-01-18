package com.jimrennie.junit.world5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 5.1 Basic extension
 *
 * JUnit's extensions provide a way to add extra functionality to the testing process beyond the standard annotations
 * and assertions provided by JUnit. They can be added to a test class using the @ExtendWith(class) annotation.
 *
 * Let's get our feet wet by writing a simple extension.
 *
 * Instructions:
 * Write an extension that resolves any integer parameters to your favorite number and test it out on this class
 *
 * Hint: Use the ParameterResolver hook.
 */
class TestWorld5Level1 {

	@Test
	void test(Integer yourFavoriteNumber) {
		System.out.println("Your favorite number is: " + yourFavoriteNumber);
		assertNotNull(yourFavoriteNumber);
	}

}
