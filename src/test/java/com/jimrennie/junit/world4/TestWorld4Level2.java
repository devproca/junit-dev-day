package com.jimrennie.junit.world4;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 4.2 Recursive assertions
 *
 * Recursive assertions and comparisons let you run assertions on all fields of the object.
 *
 * Here's how to start a recursive assertion:
 * assertThat(object).usingRecursiveAssertion()
 *
 * Here's how to start a recursive comparison:
 * assertThat(batman).usingRecursiveComparison()
 *
 * Instructions:
 * Add single recursive assertion based on instructions of each test
 */
class TestWorld4Level2 {

	private static final SuperHero BATMAN = new SuperHero("Batman", null, Set.of(Weakness.noSuperPowers()));
	private static final SuperHero DORA_THE_EXPLORER = new SuperHero("Dora", null, Set.of(Weakness.noSuperPowers()));

	/**
	 * 1. test that superHero has no null fields. This test should fail. Check out the test results.
	 * 2. Ignore the power field as part of your assertion to get the test to pass.
	 *
	 * Note:
	 * This is a great way to make sure when a future developer adds a new field to a class, they don't forget about
	 * your precious test
	 */
	@Test
	void testNoNullFields() {
		SuperHero superHero = BATMAN;

		assertThat(superHero)
				.usingRecursiveAssertion()
				.ignoringFields("power")
				.hasNoNullFields();
	}

	/**
	 * test that batman and dora the explorer are the equal excluding their name.
	 */
	@Test
	void testBatmanEqualToDora() {
		SuperHero batman = BATMAN;
		SuperHero dora = DORA_THE_EXPLORER;

		assertThat(batman).usingRecursiveComparison()
				.ignoringFields("name")
				.isEqualTo(dora);
	}

	private record SuperHero(String name, String power, Set<Weakness> weaknesses) {
	}

	private record Weakness(String type) {

		private static Weakness noSuperPowers() {
			return new Weakness("Lack of superhuman abilities");
		}

	}
}
