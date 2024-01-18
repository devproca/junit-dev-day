package com.jimrennie.junit.world4;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

/**
 * 4.1 AssertJ assertions
 *
 * AssertJ is a library for fluent and expressive assertions. It provides a set of intuitive, readable, and
 * flexible methods to write assertions for unit tests.
 *
 * The syntax for AssertJ is designed to read like a sentence. Here are a few examples:
 * assertThat(actual).isEqualTo(expected);
 * assertThat("Hello").startsWith("He").endsWith("lo").contains("l");
 *
 * More info on AssertJ can be found here:
 * <a href="https://assertj.github.io/doc/">AssertJ Docs</a>
 *
 * Instructions:
 * Write a single AssertJ assertThat assertion based on the instructions of each test
 */
class TestWorld4Level1 {

	/**
	 * Test that youAreAwesome is true
	 */
	@Test
	void testYouAreAwesome() {
		boolean youAreAwesome = true;

		// TODO
	}

	/**
	 * Test that "squirtle" is in the list startingPokemon
	 */
	@Test
	void testSquirtleAStartingPokemon() {
		List<String> startingPokemon = List.of("bulbasaur", "charmander", "squirtle");

		// TODO
	}

	/**
	 * Test that listA contains exactly the same elements in any order as listB
	 */
	@Test
	void testListASameAsListB() {
		List<String> listA = List.of("a", "b", "c", "d");
		List<String> listB = List.of("b", "c", "d", "a");

		// TODO
	}

	/**
	 * Test that map has a size of 2 and has an entry with a key of "beef" and value of 5
	 */
	@Test
	void testMapSizeAndContents() {
		Map<String, Integer> map = Map.of(
				"beef", 5,
				"soda", 100
		);

		// TODO
	}

}
