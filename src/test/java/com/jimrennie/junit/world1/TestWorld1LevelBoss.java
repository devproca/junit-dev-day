package com.jimrennie.junit.world1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

/**
 * 1.boss
 * {@link DayOfWeekMessageProvider#getMessage(DayOfWeek)} needs some tests!
 * <p>
 * On Monday it should return: "Looks like somebody has a case of the Monday's"
 * On Wednesday it should return: "It's Wednesday my dudes!"
 * All other days of the week should return null.
 * <p>
 * Write as many tests as needed to make sure all days return the correct message!
 */
class TestWorld1LevelBoss {

	// There are a lot of different ways to answer this question :)

	@Test
	void testMonday() {
		String message = DayOfWeekMessageProvider.getMessage(DayOfWeek.MONDAY);

		assertEquals("Looks like somebody has a case of the Monday's", message);
	}

	@Test
	void testWednesday() {
		String message = DayOfWeekMessageProvider.getMessage(DayOfWeek.WEDNESDAY);

		assertEquals("It's Wednesday my dudes!", message);
	}

	@EnumSource(value = DayOfWeek.class, mode = EXCLUDE, names = {"MONDAY", "WEDNESDAY"})
	@ParameterizedTest
	void testOtherDays(DayOfWeek dayOfWeek) {
		String message = DayOfWeekMessageProvider.getMessage(dayOfWeek);

		assertNull(message);
	}


}
