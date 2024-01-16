package com.jimrennie.junit.world2;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * 2.3 Argument matchers
 *
 * Argument matchers allow you to define flexible and expressive conditions for the arguments that are passed to mocked
 * or verified methods.
 *
 * {@link org.mockito.ArgumentMatchers } can be used by passing them in as arguments to the method being mocked or verified.
 *
 * Common matchers include {@link ArgumentMatchers#any()} and {@link ArgumentMatchers#eq(Object)} but there are many
 * more including custom ones. They are typically statically imported.
 * A complete list of static imports can be found here:
 * <a href="https://site.mockito.org/javadoc/current/org/mockito/ArgumentMatchers.html">Mockito ArgumentMatchers javadoc</a>
 */
@ExtendWith(MockitoExtension.class)
public class TestWorld2Level3 {

	@Mock
	private GoodCatNameDetector goodCatNameDetector;

	/**
	 * You created a {@link GoodCatNameDetector} interface and want to make sure it works, but it's only returning true
	 * for Dalin.
	 * <p>
	 * Instructions:
	 * Using an argument matcher make {@link GoodCatNameDetector#isGoodName(String)} return true for everyone.
	 */
	@ValueSource(strings = {"Jim", "Jeff", "Gabriel", "Haden", "Jessie", "Carole", "David"})
	@ParameterizedTest
	void everyCatNameIsAGoodCatName(String name) {
		when(goodCatNameDetector.isGoodName("Dalin")).thenReturn(true);

		assertTrue(goodCatNameDetector.isGoodName(name));
	}

	/**
	 * You've decided that if the {@link GoodCatNameDetector} is provided with a null name, it should return false
	 * because null is obviously not a good name.
	 *
	 * Instructions:
	 * Using multiple {@link ArgumentMatchers}, make the assertions in the test pass.
	 */
	@Test
	void everyCatNameIsAGoodCatNameExceptNull(String name) {
		// TODO

		assertAll(
				() -> assertTrue(goodCatNameDetector.isGoodName("Bob"), "Bob"),
				() -> assertTrue(goodCatNameDetector.isGoodName("Diane"), "Diane"),
				() -> assertFalse(goodCatNameDetector.isGoodName(null), "null")
		);
	}

}
