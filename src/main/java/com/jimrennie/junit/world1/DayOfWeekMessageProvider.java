package com.jimrennie.junit.world1;

import java.time.DayOfWeek;

public class DayOfWeekMessageProvider {
	
	public static String getMessage(DayOfWeek dayOfWeek) {
		return switch (dayOfWeek) {
			case MONDAY -> "Looks like somebody has a case of the Monday's";
			case WEDNESDAY -> "It's Wednesday my dudes!";
			case TUESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY -> null;
		};
	}
}
